package com.franquiciaProductos.franquiciaProductos.controller;

import com.franquiciaProductos.franquiciaProductos.dto.FranquiciaDto;
import com.franquiciaProductos.franquiciaProductos.dto.ProductoSucursalDto;
import com.franquiciaProductos.franquiciaProductos.model.Franquicia;
import com.franquiciaProductos.franquiciaProductos.model.Sucursal;
import com.franquiciaProductos.franquiciaProductos.service.FranquiciaService;
import com.franquiciaProductos.franquiciaProductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins =  { "*"})
@RestController
@RequestMapping("adminFranquicia")
public class FranquiciaController {

    @Autowired
    FranquiciaService franquiciaService;

    @Autowired
    ProductoService productoService;

    @PostMapping(value = "/franquicia")
    public FranquiciaDto createFranquicia(
            @RequestParam(value = "nombre") String nombre) {

            Franquicia franquicia = new Franquicia(nombre);
            return franquiciaService.saveFranquicia(franquicia);

    }

    @PutMapping(value = "/franquicia/updatename")
    public ResponseEntity<?> updateNameFranquicia(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "nombre") String nombre) {

        Franquicia franquicia = franquiciaService.getFranquiciaById(id);

        if(franquicia!=null){
            franquicia.setNombre(nombre);
            return ResponseEntity.ok(franquiciaService.saveFranquicia(franquicia));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de franquicia ingresada no existe.");
        }
    }

    @GetMapping(value = "/franquicia/productowithmMorestockbysucursal")
    public ResponseEntity<?> productowithmMorestockbysucursal(
            @RequestParam(value = "id") long id) {

        Franquicia franquicia = franquiciaService.getFranquiciaById(id);

        if(franquicia!=null){
            List<ProductoSucursalDto> ListProductoSucursalDto = new ArrayList<ProductoSucursalDto>();

            for (Sucursal sucur : franquicia.getSucursales()){
                ListProductoSucursalDto.add(
                        new ProductoSucursalDto(
                                productoService.findProductoWithMoreStockBySucursal(sucur.id).nombre,
                                sucur.nombre
                        )
                );
            }
            return ResponseEntity.ok(ListProductoSucursalDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de franquicia ingresado no existe.");
        }
    }


}
