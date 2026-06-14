package com.villyrosa.hearthstone.exception;

import java.time.LocalDateTime;

public record ErrorResponse (
        LocalDateTime timestamp,
        Integer status,
        String erro,
        String mensagem
) {
}
