package com.chegusBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chegusBoot.beans.DataBank;

@Repository
public interface DataRepo extends JpaRepository<DataBank, Long>{

}
