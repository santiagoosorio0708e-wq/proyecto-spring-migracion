package com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatconversationaisetting.model.aggregate.ChatAiSettings;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatAiSettingsRepository;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatAiSettingsEntity;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatAiSettingsDataMapper;

public class ChatAiSettingsRepositoryAdapter implements ChatAiSettingsRepository {
    private final ChatAiSettingsDbRepository repository;
    private final ChatAiSettingsDataMapper mapper;

    public ChatAiSettingsRepositoryAdapter(ChatAiSettingsDbRepository repository, ChatAiSettingsDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiSettings save(ChatAiSettings aggregate) {
        ChatAiSettingsEntity entityObj = mapper.toJpa(aggregate);
        ChatAiSettingsEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiSettings> findById(ChatAiSettingsId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiSettings> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatAiSettings aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
