package com.facespedes.todolist.task.application.use_cases;

import com.facespedes.todolist.UnitTestCase;
import com.facespedes.todolist.shared.domain.bus.event.DomainEvent;
import com.facespedes.todolist.shared.domain.bus.event.EventBus;
import com.facespedes.todolist.task.domain.TaskMother;
import com.facespedes.todolist.task.domain.aggregate.Task;
import com.facespedes.todolist.task.domain.events.TaskCompletedDomainEvent;
import com.facespedes.todolist.task.domain.ports.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class TaskFinisherTest extends UnitTestCase {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private EventBus eventBus;

    @InjectMocks
    private TaskFinisher taskFinisher;

    @Test
    void taskShouldBeDone_WhenFinishTask() {
        Task task = TaskMother.random();
        given(taskRepository.findById(task.getId())).willReturn(Optional.of(task));

        taskFinisher.finishTask(task.getId().value());

        assertThat(task.isDone()).isTrue();
        verify(taskRepository).save(task);
        ArgumentCaptor<List<DomainEvent>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(eventBus).publish(argumentCaptor.capture());
        checkIfEventIsPublished(argumentCaptor.getValue(), TaskCompletedDomainEvent.class);
    }

    private static void checkIfEventIsPublished(List<DomainEvent> eventsToPublish, Class<? extends DomainEvent> eventClass) {
        assertThat(eventsToPublish.stream().anyMatch(eventClass::isInstance)).isTrue();
    }
}
