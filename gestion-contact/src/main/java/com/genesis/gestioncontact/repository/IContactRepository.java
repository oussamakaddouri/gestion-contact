package com.genesis.gestioncontact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genesis.gestioncontact.entity.Contact;

public interface IContactRepository extends JpaRepository<Contact, Long> {

}
