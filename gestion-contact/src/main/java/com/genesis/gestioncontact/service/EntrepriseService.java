package com.genesis.gestioncontact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.gestioncontact.entity.Entreprise;
import com.genesis.gestioncontact.exception.ResourceNotFoundException;
import com.genesis.gestioncontact.repository.IContactRepository;
import com.genesis.gestioncontact.repository.IEntrepriseRepository;

@Service
public class EntrepriseService {

	@Autowired
	private IEntrepriseRepository entrepriseRepository;
	@Autowired
	private IContactRepository contactRepository;

	public Entreprise saveEntreprise(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}

	public List<Entreprise> findAllEntreprise() {
		return entrepriseRepository.findAll();
	}

	public void deleteEntreprise(Long id) {
		entrepriseRepository.delete(entrepriseRepository.findById(id).<ResourceNotFoundException>orElseThrow(() -> {
			throw new ResourceNotFoundException(String.format("Entreprise avec ID %s non trouvée", id));
		}));
	}

	public Entreprise findEntrepriseByNTva(String numeroTva) {
		return entrepriseRepository.findEntrepriseByNumeroTva(numeroTva);

	}

	public Entreprise addContactToEntreprise(Long contactId, Long entrepriseId) {
		Entreprise entreprise = entrepriseRepository.findById(entrepriseId).<ResourceNotFoundException>orElseThrow(() -> {
			throw new ResourceNotFoundException(String.format("Entreprise avec ID %s non trouvée", entrepriseId));
		});
		entreprise.addContact(contactRepository.findById(contactId).<ResourceNotFoundException>orElseThrow(() -> {
			throw new ResourceNotFoundException(String.format("Contact avec ID %s non trouvé", contactId));
		}));
		return entrepriseRepository.save(entreprise);
	}

	public Entreprise updateEntreprise(Entreprise entreprise, Long id) {
		Optional<Entreprise> entrepriseToUpdate = entrepriseRepository.findById(id);
		if (entrepriseToUpdate.isPresent()) {
			entreprise.getAdresse().setAdresseId(entrepriseToUpdate.get().getAdresse().getAdresseId());
			entrepriseToUpdate.get().setNumeroTva(entreprise.getNumeroTva());
			entrepriseToUpdate.get().setAdresse(entreprise.getAdresse());
			return entrepriseRepository.save(entrepriseToUpdate.get());
		} else {
			throw new ResourceNotFoundException(String.format("Entreprise avec ID %s non trouvée", id));
		}
	}
}
