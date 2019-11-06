package com.zitro.zbackend.persistence.repository.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zitro.zbackend.persistence.domain.Deposit;

@Repository
public interface DepositJpaDao extends JpaRepository<Deposit, Long>, JpaSpecificationExecutor<Deposit> {

	@Query("FROM Deposit d where d.player.uuid = :player_uuid")
	public List<Deposit> findAllByPlayerUUID(@Param("player_uuid")UUID uuid);
	
}
