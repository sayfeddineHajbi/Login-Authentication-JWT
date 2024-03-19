package com.pfe.federation.IService;

import com.pfe.federation.entities.PermissionSupplementaire;
import com.pfe.federation.entities.User;

import java.util.List;

public interface IPermissionSupplementaireService {

    List<PermissionSupplementaire> getAllSupplementaire();
    PermissionSupplementaire createSupPermission(PermissionSupplementaire supplementaire);
    void deletesupplementaire(Integer roleId);
    PermissionSupplementaire findByName(String name);
    PermissionSupplementaire findById(Integer roelId);
    User removeUserFromSupplementaire(Integer userId, Integer permissionSupplementaireId);
    User assignUerToSupplementaire(Integer userId, Integer permissionSupplementaireId);
    PermissionSupplementaire removeAllUserFromSupplementaire(Integer permissionSupplementaireId);
}
