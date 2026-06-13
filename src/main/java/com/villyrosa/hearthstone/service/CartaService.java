package com.villyrosa.hearthstone.service;

import com.villyrosa.hearthstone.entity.Carta;
import com.villyrosa.hearthstone.repository.CartaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaService {

    private final CartaRepository cartaRepository;

    public List<Carta> findAll() {
        return this.cartaRepository.findAll();
    }

    public Carta findById(Long id) {
        return this.cartaRepository.findById(id).orElse(null);
    }

    public Carta save(Carta carta) {
        return this.cartaRepository.save(carta);
    }

    public Carta update(Carta carta) {
        return this.cartaRepository.save(carta);
    }

    public void deleteById(Long id) {
        Carta carta = this.findById(id);
        this.cartaRepository.delete(carta);
    }

}
