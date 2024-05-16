package com.kai.todolist.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    ITEM_NOT_FOUND("101","Item not found"),
    DATE_COULD_NOT_BE_CONVERTED("102","Date could not be converted!"),
    PARAMETER_CANNOT_BE_NULL("103","Parameter cannot be null"),;

    private final String code;
    private final String Detail;
}
