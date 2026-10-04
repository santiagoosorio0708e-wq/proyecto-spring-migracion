package com.backintro.infrastructure.aimodel.adapters.in.rest.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateAiModelReq(UUID providerModelId, String nameModel, String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens, Integer contextWindow) {
}
