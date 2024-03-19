package com.pfe.federation.user;


import com.pfe.federation.entities.Role;

import java.util.Set;

public record UserRecord(Integer id, String name, String email, Set<Role> roles){}
