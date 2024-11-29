package com.metmwah.triviaparty.core.dto;

import lombok.Data;

@Data
public class AuthResponseDTO extends BasicDTO {
    protected String token;
    protected String email;
}
