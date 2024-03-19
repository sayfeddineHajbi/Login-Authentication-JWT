package com.pfe.federation.IService;

import com.pfe.federation.entities.Permission;
import com.pfe.federation.entities.Role;

import java.util.List;

public interface IPermissionService {
    List<Role> getAllPermissions();
    Permission createPermission(Permission permission);
    void deletePermission(Integer permissionId);
    Permission findByName(String name);
    Permission findById(Integer permissionId);
//    Role removePermissionFromRole(Integer roleId, Integer permissionId);
//    User assignUerToRole(Integer userId, Integer roleId);
//    Role removeAllUserFromRole(Integer roleId);
}
