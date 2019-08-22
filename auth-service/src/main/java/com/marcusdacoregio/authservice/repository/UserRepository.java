package com.marcusdacoregio.authservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.marcusdacoregio.authservice.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

	List<UserEntity> findByPassword(String password);

}
