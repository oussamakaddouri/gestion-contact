package com.genesis.gestioncontact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.gestioncontact.entity.Contact;
import com.genesis.gestioncontact.entity.Freelance;
import com.genesis.gestioncontact.exception.ResourceNotFoundException;
import com.genesis.gestioncontact.repository.IContactRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactService {

	@Autowired
	private IContactRepository contactRepository;

	public Contact saveContact(Contact contact) {
		log.info("Inside creerContact of ContactService");
		return contactRepository.save(contact);
	}

	public List<Contact> findAllContact() {
		log.info("Inside findAllContact of ContactService");
		return contactRepository.findAll();
	}

	public void deleteContact(Long id) {
		contactRepository.delete(contactRepository.findById(id).<ResourceNotFoundException>orElseThrow(() -> {
			throw new ResourceNotFoundException(String.format("Contact avec ID %s non trouvé", id));
		}));
	}

	public Contact updateContact(Contact contact, Long id) {
		Optional<Contact> contactToUpdate = contactRepository.findById(id);
		if (contactToUpdate.isPresent()) {
			contact.getAdresse().setAdresseId(contactToUpdate.get().getAdresse().getAdresseId());
			contactToUpdate.get().setNom(contact.getNom());
			contactToUpdate.get().setPrenom(contact.getPrenom());
			contactToUpdate.get().setAdresse(contact.getAdresse());
			if (contact instanceof Freelance) {
				((Freelance) contactToUpdate.get()).setNumeroTva(((Freelance) contact).getNumeroTva());
			}
			return contactRepository.save(contactToUpdate.get());
		} else {
			throw new ResourceNotFoundException(String.format("Contact avec ID %s non trouvé", id));
		}
	}
}
