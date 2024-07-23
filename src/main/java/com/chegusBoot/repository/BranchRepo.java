package com.chegusBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegusBoot.beans.DataBranch;

@Repository
public interface BranchRepo extends JpaRepository<DataBranch,Long>{

}