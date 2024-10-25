package com.github.brianlin.user_login_system.service;

import com.github.brianlin.user_login_system.model.User;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/10/25 下午 06:49
 * @Version 1.0
 */
public interface UserService {

    public void register(User user);

    public boolean login(String userName, String password);

    public User findByUserName(String userName);
}
