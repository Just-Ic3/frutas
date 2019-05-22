package com.alex.frutas.repositories;

import com.alex.frutas.entities.Fruta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FrutaRepository extends JpaRepository<Fruta,String> {
    Fruta findByNombre(String nombre);
    Fruta findByIdEquals(String id);
    Page<Fruta> findByDescripcionLike(String descripcion, Pageable pageable);
}
