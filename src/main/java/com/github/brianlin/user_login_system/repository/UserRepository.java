package com.github.brianlin.user_login_system.repository;

import com.github.brianlin.user_login_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ClassName:
 * Description:
 *                  如果有添加 Spring boot data JPA 的依賴的話，它就會自動將 "所有繼承JpaRepository的接口" 自動提供 實現類，
 *                  也就是說像這邊它就會在運行時透過反射那些自動提供 UserRepository的實現類，提供實現類就代表 它實現了其內部繼承、聲明的抽象方法!
 *
 *                  具體來說提供了:
 *                                  1.從父類繼承而來的抽象方法們
 *                                          ex: 標準 CRUD 操作方法（例如 save()、findById()、findAll() 等）。
 *                                  2.在 UserRepository額外聲明的抽象方法也可以，但必須符合命名規則，JPA才能夠順利實現該方法的邏輯
 *                                          ex: User findByUsername(String username);
 *                                          命名規則:
 *                                                  1.方法名通常以動詞開始，例如 find、read、get、delete等 去對應sql中的SELECT、DELETE等
 *                                                  2.使用實體類的名稱或其屬性的名稱作為查詢的條件。
 *                                                    例如，對於 User 實體，可以使用 username、email、age 等作為條件。
 *                                                  3.可以在方法名中使用條件運算子來定義查詢條件：
 *                                                     By：表示依據某個屬性查詢。 也就是SQL中的條件判斷 WHERE
 *                                                     And / Or：可以用來結合多個條件，例如：findByUsernameAndAge。
 *                                                  4.可以在方法名中使用 OrderBy、Top 來定義排序或限制結果數量，對應SQL中的ORDER BY、LIMIT等
 *                                                    例如：findTop10ByOrderByCreatedDateDesc()：查詢最新的 10 條記錄。
 * @Author Rin
 * @Create 2024/10/21 下午 10:31
 * @Version 1.0
 */
@Repository //這讓spring辨別該interface是存取層的組件，並能將此interface下的方法出現異常時，統一報DataAccessException，這邊已經使用JPA的情況下功用剩後者。
public interface UserRepository extends JpaRepository<User,Long> {
    // 可以在這裡定義其他查詢方法，例如：
    // User findByUsername(String username);

    Optional<User> findByUsername(String username);

}
