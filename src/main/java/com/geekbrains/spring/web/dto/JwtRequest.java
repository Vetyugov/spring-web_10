package com.geekbrains.spring.web.dto;

import lombok.Data;

/**
 * Приходит от клиента
 */
@Data
public class JwtRequest {
    private String username;
    private String password;
}
