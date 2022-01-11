package com.geekbrains.spring.web.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Класс для подключения файла secrets.properties
 */
@Configuration
@PropertySource("secrets.properties")
public class AppConfig {
}
