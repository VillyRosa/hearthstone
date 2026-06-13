package com.villyrosa.hearthstone.controller;

import com.villyrosa.hearthstone.controller.request.CartaRequest;
import com.villyrosa.hearthstone.controller.response.CartaResponse;
import com.villyrosa.hearthstone.entity.Carta;
import com.villyrosa.hearthstone.enums.ClasseCarta;
import com.villyrosa.hearthstone.enums.TipoCarta;
import com.villyrosa.hearthstone.mapper.CartaMapper;
import com.villyrosa.hearthstone.service.CartaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carta")
@RequiredArgsConstructor
public class CartaController {

    private final CartaService cartaService;

    @GetMapping
    public ResponseEntity<List<CartaResponse>> findAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) ClasseCarta classe,
            @RequestParam(required = false) TipoCarta tipo
    ) {
        List<CartaResponse> cartas = cartaService
                .findAll(nome, classe, tipo)
                .stream()
                .map(CartaMapper::toResponse)
                .toList();

        return ResponseEntity.ok(cartas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(CartaMapper.toResponse(cartaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CartaResponse> create(@Valid @RequestBody CartaRequest request) {
        CartaResponse carta = CartaMapper.toResponse(cartaService.save(CartaMapper.toEntity(request)));
        URI location = URI.create("/carta/" + carta.id());

        return ResponseEntity.created(location).body(carta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaResponse> update(@Valid @PathVariable Long id, @Valid @RequestBody CartaRequest request) {
        Carta carta = CartaMapper.toEntity(request);
        carta.setId(id);

        return ResponseEntity.ok(CartaMapper.toResponse(cartaService.update(carta)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cartaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
