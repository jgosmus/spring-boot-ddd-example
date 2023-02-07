package com.facespedes.apps.todo.backend.controllers.health_check;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public final class HealthCheckGetController {

    @GetMapping("health-check")
    public Map<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put("application", "todo_backend");
        status.put("status", "ok");

        return status;
    }
}
