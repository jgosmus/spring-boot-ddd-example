package com.facespedes.apps.todolist.backend.controllers.task_get_controller;

import com.facespedes.apps.todolist.AcceptanceTestCase;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

class TaskGetControllerTest extends AcceptanceTestCase {


    @Test
    void shouldReturn200_WhenTaskExists() throws Exception {
        String taskId = UUID.randomUUID().toString();
        String description = "Task description";
        String status = "PENDING";
        String userId = UUID.randomUUID().toString();
        Map<String, Object> expectedResponse = Map.of(
                        "id", taskId,
                        "description", description,
                        "status", status,
                        "userId", userId);

        givenThereIsATask(taskId, description, userId);

        assertResponse("/task/" + taskId, 200, expectedResponse);
    }

    @Test
    void shouldReturn404_WhenTaskNotExists() throws Exception {
        String taskId = UUID.randomUUID().toString();

        assertRequest("GET", "/task/" + taskId, 404);
    }

    private void givenThereIsATask(String id, String description, String userId) throws Exception {
        Map<String, Object> user = Map.of("id", userId, "email", "test@test.com", "password", "test");
        Map<String, Object> task = Map.of("id", id, "description", description, "userId", userId);

        assertRequestWithBody("POST", "/user", user, 201);
        assertRequestWithBody("POST", "/task", task, 201);
    }
}