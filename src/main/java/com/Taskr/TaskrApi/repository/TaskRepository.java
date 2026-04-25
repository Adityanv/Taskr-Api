package com.Taskr.TaskrApi.repository;

import com.Taskr.TaskrApi.enums.Priority;
import com.Taskr.TaskrApi.enums.TaskStatus;
import com.Taskr.TaskrApi.model.Task;
import com.Taskr.TaskrApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("SELECT t FROM Task t WHERE (t.owner = :user OR t.assignee = :user) " +
            "AND (:status IS NULL OR t.status = :status) " +
            "AND (:priority IS NULL OR t.priority = :priority)")
    List<Task> findByOwnerOrAssigneeWithFilters(
            @Param("user") User user,
            @Param("status") TaskStatus status,
            @Param("priority") Priority priority
    );

    @Query("SELECT t FROM Task t WHERE (:status IS NULL OR t.status = :status) " +
            "AND (:priority IS NULL OR t.priority = :priority)")
    List<Task> findAllWithFilters(
            @Param("status") TaskStatus status,
            @Param("priority") Priority priority
    );
    @Query("SELECT COUNT(t) FROM Task t WHERE t.dueDate < CURRENT_DATE " +
            "AND t.status != com.Taskr.TaskrApi.enums.TaskStatus.DONE")
    Long countOverdueTasks();

    Long countByOwnerId(Integer id);
}
