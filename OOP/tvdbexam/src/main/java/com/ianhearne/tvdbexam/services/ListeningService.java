package com.ianhearne.tvdbexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ianhearne.tvdbexam.models.Listening;
import com.ianhearne.tvdbexam.repositories.ListeningRepository;

@Service
public class ListeningService {
	@Autowired
	ListeningRepository listeningRepo;
	
	public Listening add(Listening newListening, BindingResult result) {
		//Validates that the show's title doesn't already exist in the database before saving it
		if(listeningRepo.findByAddressEquals(newListening.getAddress()) != null) {
			result.rejectValue("address", null, "Address is already in use");
			return null;
		}
		return listeningRepo.save(newListening);
	}
	
	public List<Listening> getAll() {
		return listeningRepo.findAll();
	}
	
	public Listening getById(Long id) {
		Optional<Listening> show = listeningRepo.findById(id);
		if(show.isPresent()) {
			return show.get();
		}
		return null;
	}
	
	public Listening updateListening(Listening listening, BindingResult result) {
		//Validates that the show's title doesn't already exist in the database before saving it, also checks to see that it isn't validating against itself
		if(listeningRepo.findByAddressEquals(listening.getAddress()) != null 
				&& !listening.getId().equals(listeningRepo.findByAddressEquals(listening.getAddress()).getId())) {
			result.rejectValue("title", null, "Title is already in use");
			return null;
		}
		return listeningRepo.save(listening);
	}
	
	public void deleteListening(Long id) {
		listeningRepo.deleteById(id);
	}
}
