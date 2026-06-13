package com.villyrosa.hearthstone.controller.request;

import com.villyrosa.hearthstone.enums.ClasseCarta;
import com.villyrosa.hearthstone.enums.TipoCarta;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CartaRequest(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "O custo de mana é obrigatório")
        @Min(value = 0, message = "O custo de mana deve ser entre 0 e 10")
        @Max(value = 10, message = "O custo de mana deve ser entre 0 e 10")
        Integer custoMana,

        @NotNull(message = "O ataque é obrigatório")
        @Min(value = 0, message = "O ataque deve ser entre 0 e 10")
        @Max(value = 10, message = "O ataque deve ser entre 0 e 10")
        Integer ataque,

        @NotNull(message = "A defesa é obrigatória")
        @Min(value = 0, message = "A defesa deve ser entre 0 e 10")
        @Max(value = 10, message = "A defesa deve ser entre 0 e 10")
        Integer defesa,

        @NotNull(message = "O tipo é obrigatório")
        TipoCarta tipo,

        @NotNull(message = "A classe é obrigatória")
        ClasseCarta classe
) {
}
