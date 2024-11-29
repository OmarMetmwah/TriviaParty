package com.metmwah.triviaparty.core.dto;

import lombok.Data;

@Data
public class UserDTO extends BasicDTO {
    protected String email;
    protected String password;
}
