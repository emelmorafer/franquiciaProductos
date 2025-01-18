package com.franquiciaProductos.franquiciaProductos.service.impl;

import com.franquiciaProductos.franquiciaProductos.dto.FranquiciaDto;
import com.franquiciaProductos.franquiciaProductos.model.Franquicia;
import com.franquiciaProductos.franquiciaProductos.repository.FranquiciaRepository;
import com.franquiciaProductos.franquiciaProductos.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FranquiciaServiceImpl implements FranquiciaService {

    @Autowired
    FranquiciaRepository franquiciaRepository;

    public FranquiciaDto saveFranquicia(Franquicia franquicia) {
        if (!franquicia.getNombre().equals("")) {
            return domainToDto(franquiciaRepository.save(franquicia));
        } else {
            return new FranquiciaDto();
        }
    }

    public Franquicia getFranquiciaById(long id) {
        Optional<Franquicia> franquiciaOpt = franquiciaRepository.findById(id);
        return franquiciaOpt.orElse(null);
    }

    public FranquiciaDto domainToDto(Franquicia franquicia) {
        return new FranquiciaDto(
                franquicia.id,
                franquicia.nombre);
    }


}
