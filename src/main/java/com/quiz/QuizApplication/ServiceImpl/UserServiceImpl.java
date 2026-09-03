package com.quiz.QuizApplication.ServiceImpl;

import com.quiz.QuizApplication.Entity.User;
import com.quiz.QuizApplication.Repository.UserRepo;
import com.quiz.QuizApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public User doRegister(User user) {

        return userRepo.save(user);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepo.getUserByUsernameAndPassword(username,password);
    }
}
