package com.backintro.infrastructure.chatconversation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatconversation.usecase.*;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationDataMapper;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories.*;

@Configuration
public class ChatConversationAppConfig {

    @Bean
    public ChatConversationDataMapper chatconversationDataMapper() {
        return new ChatConversationDataMapper();
    }

    @Bean
    public ChatConversationRepository chatconversationRepository(ChatConversationDbRepository repository, ChatConversationDataMapper mapper) {
        return new ChatConversationRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatConversationUseCase registerChatConversationUseCase(ChatConversationRepository repository) {
        return new RegisterChatConversationUseCase(repository);
    }

    @Bean
    public GetChatConversationByIdUseCase getChatConversationByIdUseCase(ChatConversationRepository repository) {
        return new GetChatConversationByIdUseCase(repository);
    }

    @Bean
    public ListChatConversationUseCase listChatConversationUseCase(ChatConversationRepository repository) {
        return new ListChatConversationUseCase(repository);
    }

    @Bean
    public UpdateChatConversationUseCase updateChatConversationUseCase(ChatConversationRepository repository) {
        return new UpdateChatConversationUseCase(repository);
    }

    @Bean
    public DeleteChatConversationUseCase deleteChatConversationUseCase(ChatConversationRepository repository) {
        return new DeleteChatConversationUseCase(repository);
    }
}
