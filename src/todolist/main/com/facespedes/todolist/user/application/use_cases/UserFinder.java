package com.facespedes.todolist.user.application.use_cases;

import com.facespedes.todolist.shared.domain.Service;
import com.facespedes.todolist.user.application.dto.UserFinderResponse;
import com.facespedes.todolist.user.domain.services.DomainUserFinder;
import com.facespedes.todolist.user.domain.User;
import com.facespedes.todolist.shared.domain.UserId;
import com.facespedes.todolist.user.domain.UserRepository;

@Service
public class UserFinder {

    private final DomainUserFinder domainUserFinder;

    public UserFinder(UserRepository userRepository) {
        this.domainUserFinder = new DomainUserFinder(userRepository);
    }

    public UserFinderResponse findUser(String id) {
        UserId userId = new UserId(id);
        User user = domainUserFinder.findUser(userId).orElseThrow();
        return new UserFinderResponse(user.getId(), user.getEmail());
    }
}
