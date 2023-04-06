package com.malek.vols.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.malek.vols.entities.Vol;
import com.malek.vols.repos.VolRepository;

@Service
public class VolServiceImpl implements VolService {

	@Autowired
	VolRepository volRepository;
	
	public Vol saveVol(Vol v) {
		return volRepository.save(v);
	}

	public Vol updateVol(Vol v) {
		
		return volRepository.save(v);
	}

	public void deleteVol(Vol v) {
		
		volRepository.delete(v);
		
	}

	public void deleteVolById(Long id) {
		
		volRepository.deleteById(id);
	}

	public Vol getVol(Long id) {
		
		return volRepository.findById(id).get();
	}

	public List<Vol> getAllVols() {
		
		return volRepository.findAll();
	}
	@Override
	public Page<Vol> getAllVolsParPage(int page, int size) {
	return volRepository.findAll(PageRequest.of(page, size));
	}

	
}
