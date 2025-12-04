package com.example.quiz15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quiz15.entity.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, String> {

	@Query(value = "select count(email) from user where email = ?1", nativeQuery = true)
	public int getCountByEmail(String email);

	@Query(value = "select * from user where email = ?1", nativeQuery = true)
	public User getByEmail(String email);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user(name, phone, email, age, password, role) VALUES(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	int addInfo(String name, String phone, String email, int age, String password, String role);
	
	@Modifying
	@Transactional
	@Query(value = "delete from user where email = ?1", nativeQuery = true)
	int  deleteInfo(String email);
}
