package com.backintro.infrastructure.chatairunerror.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatairunerror.usecase.*;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.mappers.ChatAiRunErrorDataMapper;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.repositories.*;

@Configuration
public class ChatAiRunErrorAppConfig {

    @Bean
    public ChatAiRunErrorDataMapper chatairunerrorDataMapper() {
        return new ChatAiRunErrorDataMapper();
    }

    @Bean
    public ChatAiRunErrorRepository chatairunerrorRepository(ChatAiRunErrorDbRepository repository, ChatAiRunErrorDataMapper mapper) {
        return new ChatAiRunErrorRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunErrorUseCase registerChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new RegisterChatAiRunErrorUseCase(repository);
    }

    @Bean
    public GetChatAiRunErrorByIdUseCase getChatAiRunErrorByIdUseCase(ChatAiRunErrorRepository repository) {
        return new GetChatAiRunErrorByIdUseCase(repository);
    }

    @Bean
    public ListChatAiRunErrorUseCase listChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new ListChatAiRunErrorUseCase(repository);
    }

    @Bean
    public UpdateChatAiRunErrorUseCase updateChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new UpdateChatAiRunErrorUseCase(repository);
    }

    @Bean
    public DeleteChatAiRunErrorUseCase deleteChatAiRunErrorUseCase(ChatAiRunErrorRepository repository) {
        return new DeleteChatAiRunErrorUseCase(repository);
    }
}
