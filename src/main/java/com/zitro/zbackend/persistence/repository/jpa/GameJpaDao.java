package com.zitro.zbackend.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zitro.zbackend.persistence.domain.Game;
import com.zitro.zcommon.persistence.domain.FindByNameIdEntityInterface;

public interface GameJpaDao extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game>, FindByNameIdEntityInterface<Game>{

}
