package com.gtc.user.persistence;

import com.gtc.user.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    // Query para buscar al usuario dueño de la tarea
    @Query(value = "SELECT * FROM users u WHERE :idTask = ANY (task_own)", nativeQuery = true)
    List<UserEntity> findOwnerByIdTask(Long idTask);

    // Query para buscar todos los usuarios q intervienen el la tarea
    @Query(value = "SELECT * FROM Users u WHERE :idTask = ANY (u.task_id)", nativeQuery = true)
    List<UserEntity> findEditorsByTaskId(Long idTask);
}