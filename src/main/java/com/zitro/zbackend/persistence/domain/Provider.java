package com.zitro.zbackend.persistence.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name="provider")
public class Provider implements EntityWithUUIDAndNameInterface{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "provider_uuid", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID uuid;
	
	@Column(name="provider_name")
	@Size(min=2, max=20, message="")
	@NotNull
	private String name;
	
	@Column(name="creation_datetime", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@EqualsAndHashCode.Exclude
    private Date creationDateTime;

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
