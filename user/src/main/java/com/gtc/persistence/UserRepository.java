package com.gtc.persistence;

import com.gtc.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    @Query(value = "SELECT u FROM User u WHERE :idTask = ANY (task_id)", nativeQuery = true)
    List<User> findAllUser(Long idTask);
}
