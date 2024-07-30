package com.Theatre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Theatre.enities.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
