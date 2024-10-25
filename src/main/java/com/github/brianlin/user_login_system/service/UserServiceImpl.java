package com.github.brianlin.user_login_system.service;

import com.github.brianlin.user_login_system.exception.UserNotFoundException;
import com.github.brianlin.user_login_system.model.User;
import com.github.brianlin.user_login_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/10/21 下午 10:31
 * @Version 1.0
 */
@Service //@Service可以幫助spring 在運行時識別這個類，並建立一個此class的實例物件，作為spring bean 管理，當需要Autowired 時能夠將其自動賦值。
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 註冊
     */
    @Override
    public void register(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword()); // 加密密碼
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    /**
     * login
     * @param userName
     * @param password
     * @return
     */
    @Override
    public boolean login(String userName, String password){
        Optional<User> result = userRepository.findByUsername(userName);
        if (result.isPresent()){
            User user = result.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    /**
     * 透過用戶名 查詢用戶
     * @param userName
     * @return
     */
    @Override
    public User findByUserName(String userName){
        Optional<User> result = userRepository.findByUsername(userName);
        return result.orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
