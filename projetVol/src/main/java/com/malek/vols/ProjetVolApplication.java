package com.malek.vols;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.malek.vols.entities.Vol;
import com.malek.vols.service.VolService;

@SpringBootApplication
public class ProjetVolApplication implements CommandLineRunner {

	@Autowired
	VolService volService;
	public static void main(String[] args) {
	SpringApplication.run(ProjetVolApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	volService.saveVol(new Vol("TU620","TunisAir",new Date(),"Istanbul","atteri"));
	volService.saveVol(new Vol("TU516","NouvelAir",new Date(),"France","a la porte d'embarquement"));
	volService.saveVol(new Vol("TU620","TunisAir",new Date(),"Egypte","annule"));


}}
