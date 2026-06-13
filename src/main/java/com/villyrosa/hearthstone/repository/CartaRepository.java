package com.villyrosa.hearthstone.repository;

import com.villyrosa.hearthstone.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Long> {
}
