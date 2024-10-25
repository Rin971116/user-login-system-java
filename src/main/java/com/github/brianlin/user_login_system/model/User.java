package com.github.brianlin.user_login_system.model;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/10/21 下午 07:17
 * @Version 1.0
 */
@Entity // 1. 表示這個類是一個 JPA 實體，對應資料庫中的一個表，簡單來說就是讓JPA能夠辨別這個class 是對應db中的 table，因此它才可以自動實現SQL語句。
public class User {

    @Column(name = "user_id")
    @Id // 2. 指定這個欄位為主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. 設置主鍵生成策略為自動遞增，db建表時仍須設定 AUTO_INCREMENT
    private Long id;

    @Column(name = "user_name")
    private String username; // 使用者名稱欄位
    @Column(name = "password")
    private String password; // 密碼欄位
    @Column(name = "role")
    private String role;     // 使用者角色欄位，例如：USER 或 ADMIN

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }
}
