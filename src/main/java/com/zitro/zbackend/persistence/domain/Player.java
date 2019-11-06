package com.zitro.zbackend.persistence.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.zitro.zcommon.persistence.domain.EntityWithUUIDAndNameInterface;

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
@Table(name="player")
public class Player implements EntityWithUUIDAndNameInterface {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "player_uuid", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID uuid;
	
	@Column(name="player_name")
	@Size(min=2, max=20)
	@NotNull
	private String name;
	
	@Column(name="balance")
	@NotNull()
	@Min(value = 0)
	@EqualsAndHashCode.Exclude
	private float balance;
	
	@Column(name="time_left")
	@EqualsAndHashCode.Exclude
	private float timeLeft;
	
	@Column(name="deleted")
	@EqualsAndHashCode.Exclude
	private boolean deleted;
	
	@Column(name="creation_datetime", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@EqualsAndHashCode.Exclude
    private Date creationDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provider_uuid", updatable = false)
	private Provider provider;

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
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
