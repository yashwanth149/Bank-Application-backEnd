package com.chegusBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegusBoot.beans.DataPerson;

@Repository
public interface PersonRepo extends JpaRepository<DataPerson, Long>{

}
