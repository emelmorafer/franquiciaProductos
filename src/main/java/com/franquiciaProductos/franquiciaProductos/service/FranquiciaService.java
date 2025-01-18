package com.franquiciaProductos.franquiciaProductos.service;

import com.franquiciaProductos.franquiciaProductos.dto.FranquiciaDto;
import com.franquiciaProductos.franquiciaProductos.model.Franquicia;

public interface FranquiciaService {

    public FranquiciaDto saveFranquicia(Franquicia franquicia);

    public Franquicia getFranquiciaById(long id);


}
