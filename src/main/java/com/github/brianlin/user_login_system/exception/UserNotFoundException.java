package com.github.brianlin.user_login_system.exception;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/10/26 上午 04:27
 * @Version 1.0
 */

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
