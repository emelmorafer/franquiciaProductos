package com.franquiciaProductos.franquiciaProductos.repository;

import com.franquiciaProductos.franquiciaProductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.sucursal.id = :sucursalId " +
            "AND p.stock = (SELECT MAX(p2.stock) FROM Producto p2 WHERE p2.sucursal.id = :sucursalId)")
    public Producto findProductoWithMoreStockBySucursal(Long sucursalId);


}
