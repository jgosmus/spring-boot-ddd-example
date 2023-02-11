package com.facespedes.todolist.task.application.use_cases;

import com.facespedes.todolist.UnitTestCase;
import com.facespedes.todolist.shared.domain.UuidMother;
import com.facespedes.todolist.task.application.dto.TaskFinderResponse;
import com.facespedes.todolist.task.application.dto.TaskFinderResponseMother;
import com.facespedes.todolist.task.domain.TaskMother;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.exceptions.TaskNotFoundException;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class TaskFinderTest extends UnitTestCase {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskFinder taskFinder;


    @Test
    void shouldReturnTask_WhenExists() {
        Task task = TaskMother.random();
        TaskFinderResponse expectedTaskFinderResponse = TaskFinderResponseMother.fromTask(task);
        given(taskRepository.findById(task.getId())).willReturn(Optional.of(task));

        TaskFinderResponse taskFinderResponse = taskFinder.findById(task.getId().value());
        assertThat(taskFinderResponse).isEqualTo(expectedTaskFinderResponse);
    }


    @Test
    void shouldThrowException_WhenNotExists() {
        given(taskRepository.findById(any())).willReturn(Optional.empty());

        assertThatThrownBy(() -> taskFinder.findById(UuidMother.random())).isInstanceOf(TaskNotFoundException.class);

        verify(taskRepository).findById(any());
    }
}