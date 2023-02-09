package com.facespedes.todolist.user.application.use_cases;

import com.facespedes.todolist.UnitTestCase;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.application.dto.UserFinderResponse;
import com.facespedes.todolist.user.application.dto.UserFinderResponseMother;
import com.facespedes.todolist.user.domain.UserMother;
import com.facespedes.todolist.user.domain.aggregate.User;
import com.facespedes.todolist.user.domain.ports.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        given(userRepository.findById(new UserId(user.getId()))).willReturn(Optional.of(user));

        UserFinderResponse userFinderResponse = userFinder.findUser(user.getId());
        verify(userRepository, atLeastOnce()).findById(new UserId(user.getId()));
        assertEquals(expectedResponse, userFinderResponse);
    }
}