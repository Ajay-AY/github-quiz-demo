package com.quiz.QuizApplication.Repository;

import com.quiz.QuizApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(name="select c from User c where username = ?1 and password = ?2")
    User getUserByUsernameAndPassword(String username, String password);
}
