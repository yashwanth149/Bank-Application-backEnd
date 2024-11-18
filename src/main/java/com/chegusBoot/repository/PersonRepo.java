package com.chegusBoot.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegusBoot.beans.DataPerson;

@Repository
public interface PersonRepo extends JpaRepository<DataPerson, Long>{
	 default List<DataPerson> getPersons(Integer start,Integer count){
		PageRequest dataPersons = PageRequest.of(start/count, count);
		return findAll(dataPersons).getContent();
	}
}
