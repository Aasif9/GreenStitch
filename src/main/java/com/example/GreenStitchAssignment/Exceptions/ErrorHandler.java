package com.example.GreenStitchAssignment.Exceptions;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandler {

    private LocalDateTime timestamp;
    private String message;
    private String description;

}