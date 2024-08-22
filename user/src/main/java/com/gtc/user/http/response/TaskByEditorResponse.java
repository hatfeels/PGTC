package com.gtc.user.http.response;

import com.gtc.user.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskByEditorResponse {
    private String name;
    private List<TaskDTO> tastDTOList;
}
