# User Login System - Secure Registration & Login API
本專案是一個後端服務，提供註冊加密和登入驗證的 API，專注於使用 Spring Security 進行密碼加密和基本的登入驗證。

# 技術堆疊
框架：Spring Boot, Spring Security
數據庫：MySQL
測試：JUnit
依賴管理：Maven
主要依賴
spring-boot-starter-web
spring-boot-starter-security
spring-boot-starter-data-jpa
mysql-connector-java

# 安裝與運行
克隆專案後，設置數據庫：創建 user_login_system MySQL 資料庫，並在 application.properties 中配置數據庫連線資訊。

# 啟動專案：
bash中
./mvnw spring-boot:run

# API 端點概述
註冊
POST /api/users/register：新使用者註冊，密碼會被加密存儲。
登入
POST /api/users/login：驗證登入並返回結果。
