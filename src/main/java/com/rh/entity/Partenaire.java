package com.rh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table (name = "Client")
@Getter
@Setter	
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Partenaire implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nom_partenaire")
	private String nom_partenaire;
	@Column(name = "email_partenaire")
	private String email_partenaire;
	

}