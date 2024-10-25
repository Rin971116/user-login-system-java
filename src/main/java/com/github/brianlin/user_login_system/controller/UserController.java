package com.github.brianlin.user_login_system.controller;

import com.github.brianlin.user_login_system.model.User;
import com.github.brianlin.user_login_system.service.UserService;
import com.github.brianlin.user_login_system.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/10/24 上午 02:54
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired // 注入 UserService
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // 註冊新使用者
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.register(user); // 調用 service 層進行註冊
        return "User registered successfully!";
    }

    // 使用者登入
    @PostMapping("/login")
    //@RequestParam 讀取前端發fetch時的url的訊息，例如:POST /api/users/login?username=john&password=secret123，依據對應變數名賦值
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.login(username, password); // 調用 service 層登入驗證
        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }
}
