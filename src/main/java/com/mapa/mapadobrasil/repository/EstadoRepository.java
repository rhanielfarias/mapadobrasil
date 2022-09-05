package com.mapa.mapadobrasil.repository;

import com.mapa.mapadobrasil.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Integer> {
}
