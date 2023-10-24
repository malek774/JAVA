package com.ianhearne.tvdbexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianhearne.tvdbexam.models.Listening;

@Repository
public interface ListeningRepository extends CrudRepository<Listening, Long>{
	public List<Listening> findAll();
	
	public Listening findByAddressEquals(String address);
}
