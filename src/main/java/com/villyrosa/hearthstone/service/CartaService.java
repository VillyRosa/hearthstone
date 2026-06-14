package com.villyrosa.hearthstone.service;

import com.villyrosa.hearthstone.entity.Carta;
import com.villyrosa.hearthstone.enums.ClasseCarta;
import com.villyrosa.hearthstone.enums.TipoCarta;
import com.villyrosa.hearthstone.exception.CartaNotFoundException;
import com.villyrosa.hearthstone.repository.CartaRepository;
import com.villyrosa.hearthstone.specification.CartaSpecification;
import static org.springframework.data.jpa.domain.Specification.where;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaService {

    private final CartaRepository cartaRepository;

    public List<Carta> findAll(String nome, ClasseCarta classe, TipoCarta tipo) {
        return this.cartaRepository.findAll(
                where(CartaSpecification.nome(nome))
                        .and(CartaSpecification.classe(classe))
                        .and(CartaSpecification.tipo(tipo))
        );
    }

    public Carta findById(Long id) {
        return this.cartaRepository.findById(id)
                .orElseThrow(() -> new CartaNotFoundException(id));
    }

    public Carta save(Carta carta) {
        return this.cartaRepository.save(carta);
    }

    public Carta update(Carta carta) {
        Carta cartaExistente = this.findById(carta.getId());

        cartaExistente.setNome(carta.getNome());
        cartaExistente.setDescricao(carta.getDescricao());
        cartaExistente.setCustoMana(carta.getCustoMana());
        cartaExistente.setAtaque(carta.getAtaque());
        cartaExistente.setDefesa(carta.getDefesa());
        cartaExistente.setTipo(carta.getTipo());
        cartaExistente.setClasse(carta.getClasse());

        return this.cartaRepository.save(cartaExistente);
    }

    public void deleteById(Long id) {
        Carta carta = this.findById(id);
        this.cartaRepository.delete(carta);
    }

}
