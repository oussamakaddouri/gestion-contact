package com.genesis.gestioncontact.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Freelance extends Contact {
	@NotBlank(message = "Numéro de TVA est obligatoire")
	private String numeroTva;	
}
