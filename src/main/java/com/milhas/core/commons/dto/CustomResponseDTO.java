package com.milhas.core.commons.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomResponseDTO<T> {
    private List<T> body;
    private int recordsCount;

    public CustomResponseDTO(List<T> body, int recordsCount) {
        this.body = body;
        this.recordsCount = recordsCount;
    }
}
