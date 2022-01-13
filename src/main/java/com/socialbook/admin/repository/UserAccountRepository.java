package com.socialbook.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.socialbook.admin.models.UserModel;

public interface UserAccountRepository extends JpaRepository<UserModel, Long> {
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM users " +
            "WHERE (CONCAT(first_name, ' ', last_name) like %?1%) OR(id LIKE %?1%) OR (email LIKE %?1%) OR (username LIKE %?1%)")
    List<UserModel> searchUser(String search);
}
