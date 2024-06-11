package com.milhas.core.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponseDTO<T> {
    private T body;
    private int recordsCount;
}
