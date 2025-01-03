package com.milhas.core.user.infra.db.repository;

import com.milhas.core.user.infra.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, UserRepositoryCustom {
    UserDetails findByEmail(String email);
}
