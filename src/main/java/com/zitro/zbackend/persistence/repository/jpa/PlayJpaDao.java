package com.zitro.zbackend.persistence.repository.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zitro.zbackend.persistence.domain.Play;

@Repository
public interface PlayJpaDao extends JpaRepository<Play, Long>, JpaSpecificationExecutor<Play> {

	@Query("FROM Play p where p.player.uuid = :player_uuid")
	public List<Play> findAllByPlayerUUID(@Param("player_uuid")UUID uuid);
	
}
