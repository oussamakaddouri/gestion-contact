package com.genesis.gestioncontact.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.gestioncontact.entity.Entreprise;
import com.genesis.gestioncontact.service.EntrepriseService;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;

	@PostMapping
	public Entreprise creerContact(@RequestBody @Valid Entreprise entreprise) {

		return entrepriseService.saveEntreprise(entreprise);

	}

	@DeleteMapping("/{id}")
	public void deleteEntreprise(@PathVariable Long id) {
		entrepriseService.deleteEntreprise(id);

	}

	 @PutMapping("/{id}")
	 public Entreprise updateEntreprise(@RequestBody @Valid Entreprise entreprise, @PathVariable Long id) {
	 return entrepriseService.updateEntreprise(entreprise, id);
	 }

	@GetMapping("/")
	public List<Entreprise> findAllEntreprise() {
		return entrepriseService.findAllEntreprise();
	}

	@GetMapping("/{numeroTva}")
	public Entreprise findEntrepriseByNTva(@PathVariable String numeroTva) {
		return entrepriseService.findEntrepriseByNTva(numeroTva);

	}
	
	@PutMapping("/contact/{contactId}/entreprise/{entreprisetId}")
	public Entreprise addContactToEntreprise(@PathVariable Long contactId, @PathVariable Long entreprisetId) {
		return entrepriseService.addContactToEntreprise(contactId,entreprisetId);

	}
}
