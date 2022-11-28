package ru.gb.com.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FieldsValidationException {
    private List<String> messagePool;

    public FieldsValidationException(List<String> messagePool){
        this.messagePool=messagePool;
    }
}
