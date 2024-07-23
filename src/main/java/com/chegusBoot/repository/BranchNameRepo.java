package com.chegusBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegusBoot.beans.BranchName;


@Repository
public interface BranchNameRepo extends JpaRepository<BranchName, Long>{

}
