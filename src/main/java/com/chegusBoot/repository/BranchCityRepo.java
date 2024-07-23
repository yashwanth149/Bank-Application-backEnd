package com.chegusBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegusBoot.beans.BranchCity;

@Repository
public interface BranchCityRepo extends JpaRepository<BranchCity, Long>{

}
