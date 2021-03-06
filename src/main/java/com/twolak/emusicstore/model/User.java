package com.twolak.emusicstore.model;

import java.io.Serializable;

import javax.persistence.Column;
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
public class User implements Serializable {

	private static final long serialVersionUID = 4599753286807439461L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled;
	
	@Column(unique = true)
	private Long customerId;
	
//	@Builder.Default
//	@JsonBackReference
//	@ManyToMany
//	@JoinTable(name = "users_authorities",
//			joinColumns = {@JoinColumn(referencedColumnName = "user_id")},
//			inverseJoinColumns = {@JoinColumn(referencedColumnName = "authority_id")})
//	private Set<Authority> authorities = new HashSet<>();
}