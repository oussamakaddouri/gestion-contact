package com.genesis.gestioncontact.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Employe.class, name = "employe"),
    @JsonSubTypes.Type(value = Freelance.class, name = "freelance")
})
public abstract class Contact {
	@ApiModelProperty(hidden = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	@NotBlank(message = "Nom est obligatoire")
	private String nom;
	@NotBlank(message = "Prénom est obligatoire")
	private String prenom;
	
	@NotNull(message = "Adresse est obligatoire")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresseId", referencedColumnName = "adresseId")
    private Adresse adresse;
}
