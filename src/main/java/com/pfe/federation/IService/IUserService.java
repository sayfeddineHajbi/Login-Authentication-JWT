package com.pfe.federation.IService;

import com.pfe.federation.entities.User;
import com.pfe.federation.user.UserRecord;

import java.util.List;

public interface IUserService {
    User add(User user);
    List<UserRecord> getAllUsers();
    void delete(String email);
   User getUser(String email);

}
