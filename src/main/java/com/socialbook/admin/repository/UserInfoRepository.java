package com.socialbook.admin.repository;

import com.socialbook.admin.models.UserInfoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoModel, Long> {
}
