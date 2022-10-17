package com.genesis.gestioncontact.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
	@ApiModelProperty(hidden = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adresseId;
	private String rue;
	private String ville;
	
	
}
