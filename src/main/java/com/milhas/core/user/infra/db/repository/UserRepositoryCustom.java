package com.milhas.core.user.infra.db.repository;

import com.milhas.core.user.infra.db.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findAllCustom(String name, String documentNumber, String nationality);
}
