package com.zedas.customer_relationship_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {
    private String field;
    private String message;
}
