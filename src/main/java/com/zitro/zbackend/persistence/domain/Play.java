package com.zitro.zbackend.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.zitro.zcommon.persistence.domain.EntityWithIdInterface;

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
@Table(name="play")
public class Play implements EntityWithIdInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="play_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="amount_played")
	@Min(value = 1)
	@NotNull()
	@EqualsAndHashCode.Exclude
	private float amountPlayed;
	
	@Column(name="amount_won")
	@Min(value = 0)
	@NotNull()
	@EqualsAndHashCode.Exclude
	private float amountWon;
	
	@Column(name="played")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@EqualsAndHashCode.Exclude
    private Date played;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "player_uuid")
	private Player player;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Game game;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
