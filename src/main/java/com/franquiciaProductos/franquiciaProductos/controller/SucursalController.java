package com.franquiciaProductos.franquiciaProductos.controller;

import com.franquiciaProductos.franquiciaProductos.model.Franquicia;
import com.franquiciaProductos.franquiciaProductos.model.Sucursal;
import com.franquiciaProductos.franquiciaProductos.service.FranquiciaService;
import com.franquiciaProductos.franquiciaProductos.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins =  { "*"})
@RestController
@RequestMapping("adminSucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    @Autowired
    FranquiciaService franquiciaService;

    @PostMapping(value = "/sucursal")
    public ResponseEntity<?> createSucursal(
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "franquiciaId") Long franquiciaId) {

        Franquicia franquicia = franquiciaService.getFranquiciaById(franquiciaId);

        if(franquicia!=null){
            Sucursal sucursal = new Sucursal(nombre,franquicia);
            return ResponseEntity.ok(sucursalService.saveSucursal(sucursal));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de franquicia ingresado no existe.");
        }
    }

    @PutMapping(value = "/sucursal/updatename")
    public ResponseEntity<?> updateNameSucursal(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "nombre") String nombre) {

        Sucursal sucursal = sucursalService.getSucursalById(id);

        if(sucursal!=null){
            sucursal.setNombre(nombre);
            return ResponseEntity.ok(sucursalService.saveSucursal(sucursal));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de sucursal ingresado no existe.");
        }
    }

}
