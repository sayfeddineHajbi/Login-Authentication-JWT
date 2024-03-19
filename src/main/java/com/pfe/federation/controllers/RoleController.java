package com.pfe.federation.controllers;

import com.pfe.federation.IService.IRoleService;
import com.pfe.federation.entities.Role;
import com.pfe.federation.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), FOUND);
    }
    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.createRole(role), CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable("id") Integer roleId){
        roleService.deleteRole(roleId);
    }
    @PostMapping("/remove-all-users-from-role/{id}")
    public Role removeAllUsersFromRole(@PathVariable("id") Integer roleId){
       return roleService.removeAllUserFromRole(roleId);
    }
    @PostMapping("/remove-role-from-user")
    public User removeUserFromRole(@RequestParam("userId")Integer userId,
                                   @RequestParam("roleId") Integer roleId){
       return roleService.removeUserFromRole(userId, roleId);
    }

    @PostMapping("/assign-role-to-user")
    public User assignUserToRole(@RequestParam("userId")Integer userId,
                                   @RequestParam("roleId") Integer roleId){
        return roleService.assignUerToRole(userId, roleId);
    }
}
