package com.facespedes.apps.todo.backend.controllers.user_get_controller;

import com.facespedes.apps.todo.AcceptanceTestCase;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

class UserGetControllerTest extends AcceptanceTestCase {

    @Test
    void shouldReturn200_WhenUserExists() throws Exception {
        String userId = UUID.randomUUID().toString();
        String email = "test@test.com";
        String password = "test";

        givenThereIsAUser(userId, email, password);

        assertRequest("GET", "/user/" + userId, 200);
        fail();
    }

    @Test
    void shouldReturn404_WhenUserNotExists() throws Exception {
        String userId = UUID.randomUUID().toString();

        assertRequest("GET", "/user/" + userId, 404);
    }

    private void givenThereIsAUser(String id, String email, String password) throws Exception {
        Map<String, Object> user = Map.of("id", id, "email", email, "password", password);

        assertRequestWithBody("POST", "/user", user, 201);
    }
}