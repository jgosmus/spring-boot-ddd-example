package com.facespedes.todolist.user.application.use_cases;

import com.facespedes.todolist.UnitTestCase;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.shared.domain.UuidMother;
import com.facespedes.todolist.user.application.dto.UserFinderResponse;
import com.facespedes.todolist.user.application.dto.UserFinderResponseMother;
import com.facespedes.todolist.user.domain.UserMother;
import com.facespedes.todolist.user.domain.aggregate.User;
import com.facespedes.todolist.user.domain.exceptions.UserNotFoundException;
import com.facespedes.todolist.user.domain.ports.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class UserFinderTest extends UnitTestCase {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserFinder userFinder;

    @Test
    void shouldReturnUserFinderResponse_WhenUserExists() {
        User user = UserMother.random();
        UserFinderResponse expectedResponse = UserFinderResponseMother.fromUser(user);
        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));

        UserFinderResponse userFinderResponse = userFinder.findUser(user.getId().value());

        verify(userRepository, atLeastOnce()).findById(new UserId(user.getId().value()));
        assertThat(expectedResponse).isEqualTo(userFinderResponse);
    }


    @Test
    void shouldThrowUserNotFoundException_WhenUserNotExists() {
        given(userRepository.findById(any())).willReturn(Optional.empty());

        assertThatThrownBy(() -> userFinder.findUser(UuidMother.random()))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User not found");

        verify(userRepository, atLeastOnce()).findById(any());
    }
}