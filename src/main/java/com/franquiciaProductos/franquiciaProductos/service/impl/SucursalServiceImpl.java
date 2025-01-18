package com.franquiciaProductos.franquiciaProductos.service.impl;

import com.franquiciaProductos.franquiciaProductos.dto.SucursalDto;
import com.franquiciaProductos.franquiciaProductos.model.Sucursal;
import com.franquiciaProductos.franquiciaProductos.repository.SucursalRepository;
import com.franquiciaProductos.franquiciaProductos.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    public SucursalDto saveSucursal(Sucursal sucursal) {
        if (!sucursal.getNombre().equals("")) {
            return domainToDto(sucursalRepository.save(sucursal));
        } else {
            return new SucursalDto();
        }
    }

    public Sucursal getSucursalById(long id) {
        Optional<Sucursal> sucursalOpt = sucursalRepository.findById(id);
        return sucursalOpt.orElse(null);
    }

    public SucursalDto domainToDto(Sucursal sucursal) {
        return new SucursalDto(
                sucursal.id,
                sucursal.nombre,
                sucursal.getFranquicia().id);
    }


}
