package com.franquiciaProductos.franquiciaProductos.service;

import com.franquiciaProductos.franquiciaProductos.dto.ProductoDto;
import com.franquiciaProductos.franquiciaProductos.model.Producto;


public interface ProductoService {

    public ProductoDto saveProducto(Producto producto);

    public Producto getProductoById(long id);

    public Producto findProductoWithMoreStockBySucursal(Long sucursalId);

    public boolean deleteProductoById(long id);


}
