package com.villyrosa.hearthstone.mapper;

import com.villyrosa.hearthstone.controller.request.CartaRequest;
import com.villyrosa.hearthstone.controller.response.CartaResponse;
import com.villyrosa.hearthstone.entity.Carta;

public class CartaMapper {

    public static Carta toEntity(CartaRequest request) {
        return Carta.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .custoMana(request.custoMana())
                .ataque(request.ataque())
                .defesa(request.defesa())
                .tipo(request.tipo())
                .classe(request.classe())
                .build();
    }

    public static CartaResponse toResponse(Carta carta) {
        return new CartaResponse(
                carta.getId(),
                carta.getNome(),
                carta.getDescricao(),
                carta.getCustoMana(),
                carta.getAtaque(),
                carta.getDefesa(),
                carta.getTipo(),
                carta.getClasse()
        );
    }

}
