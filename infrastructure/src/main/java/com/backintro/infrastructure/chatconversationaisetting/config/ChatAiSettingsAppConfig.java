package com.backintro.infrastructure.chatconversationaisetting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatconversationaisetting.usecase.*;
import com.backintro.domain.chatconversationaisetting.port.repository.ChatAiSettingsRepository;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatAiSettingsDataMapper;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.*;

@Configuration
public class ChatAiSettingsAppConfig {

    @Bean
    public ChatAiSettingsDataMapper chatconversationaisettingDataMapper() {
        return new ChatAiSettingsDataMapper();
    }

    @Bean
    public ChatAiSettingsRepository chatconversationaisettingRepository(ChatAiSettingsDbRepository repository, ChatAiSettingsDataMapper mapper) {
        return new ChatAiSettingsRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiSettingsUseCase registerChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new RegisterChatAiSettingsUseCase(repository);
    }

    @Bean
    public GetChatAiSettingsByIdUseCase getChatAiSettingsByIdUseCase(ChatAiSettingsRepository repository) {
        return new GetChatAiSettingsByIdUseCase(repository);
    }

    @Bean
    public ListChatAiSettingsUseCase listChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new ListChatAiSettingsUseCase(repository);
    }

    @Bean
    public UpdateChatAiSettingsUseCase updateChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new UpdateChatAiSettingsUseCase(repository);
    }

    @Bean
    public DeleteChatAiSettingsUseCase deleteChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new DeleteChatAiSettingsUseCase(repository);
    }
}
