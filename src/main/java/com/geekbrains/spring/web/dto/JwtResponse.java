package com.geekbrains.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Возвращается клиенту в обмен на логин/пароль
 */
@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
}
