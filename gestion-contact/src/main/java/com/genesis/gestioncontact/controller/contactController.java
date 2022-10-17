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

import com.genesis.gestioncontact.entity.Contact;
import com.genesis.gestioncontact.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class contactController {

	@Autowired
	private ContactService contactService;

	@PostMapping
	public Contact creerContact(@RequestBody @Valid Contact contact) {
		
		return contactService.saveContact(contact);

	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactService.deleteContact(id);

	}

	@PutMapping("/{id}")
	public Contact updateContact(@RequestBody @Valid Contact contact, @PathVariable Long id) {
		return contactService.updateContact(contact, id);
	}

	@GetMapping("/")
	public List<Contact> findAllContact() {
		return contactService.findAllContact();
	}
}
