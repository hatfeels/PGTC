package com.gtc.task.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityDTO {

    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    // lista de referential
    @Column(name = "task_id")
    private List<Long> taskList;
    @Column(name = "task_own")
    private List<Long> taskOwn;
}
