package com.backintro.infrastructure.providermodelsai.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.providermodelsai.adapters.out.persistence.entity.ProviderModelAiEntity;

public interface ProviderModelAiDbRepository extends DbRepository<ProviderModelAiEntity, UUID> {
}
