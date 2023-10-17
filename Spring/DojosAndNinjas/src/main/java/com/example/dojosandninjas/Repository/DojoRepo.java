package com.example.dojosandninjas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dojosandninjas.models.Dojo;
@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
		// Read All
		List<Dojo> findAll();
}
