package com.chegusBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegusBoot.beans.LoginData;

@Repository
public interface LoginRepo extends JpaRepository<LoginData, String> {

}
