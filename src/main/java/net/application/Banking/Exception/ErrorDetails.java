package net.application.Banking.Exception;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {

    LocalDateTime localDateTime;
    String message;
    String details;
    String errorCode;
}
