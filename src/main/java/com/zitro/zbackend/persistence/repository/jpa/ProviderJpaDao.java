package com.zitro.zbackend.persistence.repository.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zitro.zbackend.persistence.domain.Provider;
import com.zitro.zcommon.persistence.domain.FindByNameUUIDEntityInterface;

@Repository
public interface ProviderJpaDao extends JpaRepository<Provider, UUID>, JpaSpecificationExecutor<Provider>, FindByNameUUIDEntityInterface<Provider>{

}
