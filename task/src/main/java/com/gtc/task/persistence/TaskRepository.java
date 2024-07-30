package com.gtc.task.persistence;

import com.gtc.task.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {


    @Query(value = "SELECT * FROM Task t WHERE :idUser = ANY (t.editors)", nativeQuery = true)
    List<Task> findAllEditableTask(Long idUser);

    @Query(value = "SELECT * FROM Task t WHERE t.owner_id = :idUser", nativeQuery = true)
    List<Task> findAllOwnTasks(Long idUser);

    @Query(value = "SELECT * FROM Task t WHERE t.is_public = true", nativeQuery = true)
    List<Task> findAllPublicTask();

}
