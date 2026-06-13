package com.villyrosa.hearthstone.controller.response;

import com.villyrosa.hearthstone.enums.ClasseCarta;
import com.villyrosa.hearthstone.enums.TipoCarta;

public record CartaResponse (
        Long id,
        String nome,
        String descricao,
        Integer custoMana,
        Integer ataque,
        Integer defesa,
        TipoCarta tipo,
        ClasseCarta classe
) {
}
