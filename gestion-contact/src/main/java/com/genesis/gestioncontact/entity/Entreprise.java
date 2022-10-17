package com.genesis.gestioncontact.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {

	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long entrepriseId;
	
	@NotBlank(message = "Numéro de TVA est obligatoire")
	private String numeroTva;

	@ManyToMany
	@JoinTable(name = "EntrepriseContact", joinColumns = { @JoinColumn(name = "entrepriseId") }, inverseJoinColumns = {
			@JoinColumn(name = "contactId") })
	Set<Contact> contacts = new HashSet<>();

	@NotNull(message = "Adresse est obligatoire")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresseId", referencedColumnName = "adresseId")
	private Adresse adresse;
	
	public boolean addContact(Contact contact){
		return contacts.add(contact);
	}
}
