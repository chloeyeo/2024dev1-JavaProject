package com.study.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude="owner")
@Table(name="tbl_cart", indexes = {@Index(name="idx_cart_email", columnList="member_owner")}) // indexing allows faster search
public class Cart {
	@Id // id is same as index
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartNo;
	
	@OneToOne
	@JoinColumn(name="member_owner")
	private Member owner;
}
