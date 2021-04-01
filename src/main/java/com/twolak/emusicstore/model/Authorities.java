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
@Table(name = "authorities")
public class Authorities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String authority;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//  @JoinColumn(name = "auth_user_id", nullable = false)
//  @OnDelete(action = OnDeleteAction.CASCADE)
//	private User user;
}
