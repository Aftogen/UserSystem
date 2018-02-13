package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDAO;
import system.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;


    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

}
