package com.franquiciaProductos.franquiciaProductos.repository;

import com.franquiciaProductos.franquiciaProductos.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {


}
