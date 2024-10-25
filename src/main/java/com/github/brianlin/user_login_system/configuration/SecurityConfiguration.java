package com.github.brianlin.user_login_system.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ClassName:
 * Description:
 *          @Configuration
 *              作用："這個標註用來表示一個類是 Spring 的配置類 "，該類可以包含一個或多個 @Bean 方法，用於定義和初始化 Spring 的組件。
 *              當你將一個類標註為 @Configuration 時，Spring 將會對這個類進行掃描，並且在應用啟動時自動執行該類中的所有 @Bean 方法，
 *              將方法返回的對象註冊為 Spring 的 bean。
 *          @Bean
 *              作用：這個標註用來標註一個 "方法"，該方法會返回一個對象，Spring 將把這個對象註冊為一個 Spring bean。
 *              功能：當 Spring 容器啟動時，它會執行這個方法，並將返回的對象存儲到 Spring 的應用上下文中。這樣，
 *              這個 bean 可以在應用的其他部分被注入使用。
 * @Author Rin
 * @Create 2024/10/25 下午 08:57
 * @Version 1.0
 */
@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
