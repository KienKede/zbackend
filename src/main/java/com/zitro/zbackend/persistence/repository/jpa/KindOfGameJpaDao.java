package com.zitro.zbackend.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zitro.zbackend.persistence.domain.KindOfGame;
import com.zitro.zcommon.persistence.domain.FindByNameIdEntityInterface;

public interface KindOfGameJpaDao extends JpaRepository<KindOfGame, Long>, JpaSpecificationExecutor<KindOfGame>, FindByNameIdEntityInterface<KindOfGame>{

}
