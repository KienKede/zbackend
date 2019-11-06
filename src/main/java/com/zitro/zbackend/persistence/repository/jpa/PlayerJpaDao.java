package com.zitro.zbackend.persistence.repository.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zitro.zbackend.persistence.domain.Player;
import com.zitro.zcommon.persistence.domain.FindByNameUUIDEntityInterface;

@Repository
public interface PlayerJpaDao extends JpaRepository<Player, UUID>, JpaSpecificationExecutor<Player>, FindByNameUUIDEntityInterface<Player>{

}