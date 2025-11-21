package com.example.task_reminder_demo.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public record CustomErrorResponse(
        String errMessage,
        String errCode,
        String errCause
) {

}
