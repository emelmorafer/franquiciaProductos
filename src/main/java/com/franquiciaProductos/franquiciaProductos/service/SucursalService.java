package com.franquiciaProductos.franquiciaProductos.service;

import com.franquiciaProductos.franquiciaProductos.dto.SucursalDto;
import com.franquiciaProductos.franquiciaProductos.model.Sucursal;

public interface SucursalService {

    public SucursalDto saveSucursal(Sucursal sucursal);

    public Sucursal getSucursalById(long id);


}
