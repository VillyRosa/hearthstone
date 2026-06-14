package com.villyrosa.hearthstone.exception;

public class CartaNotFoundException extends RuntimeException {

    public CartaNotFoundException(Long id) {
        super("Carta não encontrada com o id: " + id);
    }

}
