package com.zitro.zbackend.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zitro.zcommon.persistence.domain.EntityWithIdAndNameInterface;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString 
@EqualsAndHashCode
@Entity
@Table(name="kind_of_game")
public class KindOfGame implements EntityWithIdAndNameInterface {

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="kind_of_game_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="kind_of_game_name")
	@Size(min=2, max=20, message="")
	@NotNull
	private String name;

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
