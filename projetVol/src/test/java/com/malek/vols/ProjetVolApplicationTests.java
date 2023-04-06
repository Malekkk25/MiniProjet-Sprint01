package com.malek.vols;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.malek.vols.entities.Vol;

import com.malek.vols.repos.VolRepository;
import com.malek.vols.service.VolService;

@SpringBootTest
class ProjetVolApplicationTests {

	@Autowired
	private VolRepository volRepository;
	
	@Autowired
	private VolService volService;
	
	
	@Test
	public void testCreateVol() {
		Vol v=new Vol("TU620","TunisAir",new Date(),"France","atteri");
		volRepository.save(v);
	}
	
	@Test
	public void testFindVol()
	{
	Vol v = volRepository.findById(1L).get(); 
	System.out.println(v);
	}
	
	@Test
	public void testUpdateVol()
	{
	Vol v = volRepository.findById(1L).get();
	v.setDestination("France");
	volRepository.save(v);
	}
	
	@Test
	public void testDeleteVol()
	{
	volRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousVols()
	{
	List<Vol> vo = volRepository.findAll();
	for (Vol v : vo)
	{
	System.out.println(v);
	}}

	@Test
	public void testFindByNumVolContains()
	{
	Page<Vol> vo = volService.getAllVolsParPage(0,2);
	System.out.println(vo.getSize());
	System.out.println(vo.getTotalElements());
	System.out.println(vo.getTotalPages());
	vo.getContent().forEach(v -> {System.out.println(v.toString());
	 });
	
	}

	

}
