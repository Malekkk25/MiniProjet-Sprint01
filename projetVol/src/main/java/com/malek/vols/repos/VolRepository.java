package com.malek.vols.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malek.vols.entities.Vol;

public interface VolRepository extends JpaRepository<Vol,Long> {

}
