package com.zitro.zbackend.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zitro.zcommon.persistence.domain.EntityWithIdAndNameInterface;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString 
@EqualsAndHashCode
@Entity
@Table(name="game")
public class Game implements EntityWithIdAndNameInterface {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="game_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="game_name")
	@Size(min=2, max=20)
	@NotNull
	private String name;
	
	@Column(name="win_probabilities")
	@NotNull
	@Min(value = 1)
	@Max(value = 99)
	private int winProbabilities;
	
	@Column(name="win_amount")
	@NotNull
	@Min(value = 1)
	private float winAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "kind_of_game_id")
	private KindOfGame kindOfGame;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	
}
