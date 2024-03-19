package com.pfe.federation.IService;

import com.pfe.federation.entities.Role;
import com.pfe.federation.entities.User;

import java.util.List;



public interface IRoleService {
    List<Role> getAllRoles();
    Role createRole(Role theRole);
    void deleteRole(Integer roleId);
    Role findByName(String name);
    Role findById(Integer roelId);
    User removeUserFromRole(Integer userId, Integer roleId);
    User assignUerToRole(Integer userId, Integer roleId);
    Role removeAllUserFromRole(Integer roleId);
}
