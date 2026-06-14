package com.villyrosa.hearthstone.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String erro,
        String mensagem,
        Map<String, String> campos
) {
}
