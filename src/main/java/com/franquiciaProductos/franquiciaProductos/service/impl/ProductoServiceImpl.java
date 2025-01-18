package com.franquiciaProductos.franquiciaProductos.service.impl;

import com.franquiciaProductos.franquiciaProductos.dto.ProductoDto;
import com.franquiciaProductos.franquiciaProductos.model.Producto;
import com.franquiciaProductos.franquiciaProductos.repository.ProductoRepository;
import com.franquiciaProductos.franquiciaProductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public ProductoDto saveProducto(Producto producto) {
        if (!producto.getNombre().equals("")) {
            return domainToDto(productoRepository.save(producto));
        } else {
            return new ProductoDto();
        }
    }

    public Producto getProductoById(long id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);
        return productoOpt.orElse(null);
    }

    public Producto findProductoWithMoreStockBySucursal(Long sucursalId){
        Optional<Producto> productoOpt = Optional.ofNullable(productoRepository.findProductoWithMoreStockBySucursal(sucursalId));
        return productoOpt.orElse(null);
    }

    public boolean deleteProductoById(long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ProductoDto domainToDto(Producto producto) {
        return new ProductoDto(
                producto.id,
                producto.nombre,
                producto.stock,
                producto.getSucursal().id);
    }


}
