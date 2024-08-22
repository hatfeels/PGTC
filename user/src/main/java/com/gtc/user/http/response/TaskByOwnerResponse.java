package com.gtc.user.http.response;

import com.gtc.user.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// esta clase es redundante
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskByOwnerResponse {
    private String name;
    private List<TaskDTO> tastDTOList;
}
