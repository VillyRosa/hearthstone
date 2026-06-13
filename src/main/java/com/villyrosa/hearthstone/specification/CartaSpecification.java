package com.villyrosa.hearthstone.specification;

import com.villyrosa.hearthstone.entity.Carta;
import com.villyrosa.hearthstone.enums.ClasseCarta;
import com.villyrosa.hearthstone.enums.TipoCarta;
import org.springframework.data.jpa.domain.Specification;

public class CartaSpecification {

    public static Specification<Carta> nome(String nome) {
        return (root, query, cb) ->
                nome == null || nome.isBlank()
                        ? null
                        : cb.like(
                                cb.lower(root.get("nome")),
                            "%" + nome.toLowerCase() + "%"
                        );
    }

    public static Specification<Carta> classe(ClasseCarta classe) {
        return (root, query, cb) ->
                classe == null
                        ? null
                        : cb.equal(root.get("classe"), classe);
    }

    public static Specification<Carta> tipo(TipoCarta tipo) {
        return (root, query, cb) ->
                tipo == null
                        ? null
                        : cb.equal(root.get("tipo"), tipo);
    }

}
