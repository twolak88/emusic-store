package com.twolak.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private boolean enabled;
	private Long customerId;
	
//	@Builder.Default
//	@JsonBackReference
//	@ManyToMany
//	@JoinTable(name = "users_authorities",
//			joinColumns = {@JoinColumn(referencedColumnName = "user_id")},
//			inverseJoinColumns = {@JoinColumn(referencedColumnName = "authority_id")})
//	private Set<Authority> authorities = new HashSet<>();
}