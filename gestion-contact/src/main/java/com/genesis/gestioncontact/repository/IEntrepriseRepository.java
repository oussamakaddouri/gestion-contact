package com.genesis.gestioncontact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genesis.gestioncontact.entity.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {

	Entreprise findEntrepriseByNumeroTva(String numeroTva);

}
