package com.oguzkurtcebe.organization.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzkurtcebe.organization.model.User;
import com.oguzkurtcebe.organization.model.User2;

public interface UserRepository extends JpaRepository<User2, Long> {
	User2 findByEmail(String email);
}
