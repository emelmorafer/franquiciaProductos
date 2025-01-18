package com.franquiciaProductos.franquiciaProductos.controller;

import com.franquiciaProductos.franquiciaProductos.model.Producto;
import com.franquiciaProductos.franquiciaProductos.model.Sucursal;
import com.franquiciaProductos.franquiciaProductos.service.ProductoService;
import com.franquiciaProductos.franquiciaProductos.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins =  { "*"})
@RestController
@RequestMapping("adminProducto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    SucursalService sucursalService;

    @PostMapping(value = "/producto")
    public ResponseEntity<?> createProducto(
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "stock") int stock,
            @RequestParam(value = "sucursalId") Long sucursalId) {

        Sucursal sucursal = sucursalService.getSucursalById(sucursalId);

        if(sucursal!=null){
            Producto producto = new Producto(nombre,stock,sucursal);
            return ResponseEntity.ok(productoService.saveProducto(producto));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de sucursal ingresado no existe.");
        }
    }

    @PutMapping(value = "/producto/updatestock")
    public ResponseEntity<?> updateStockProducto(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "stock") int stock) {

        Producto producto = productoService.getProductoById(id);

        if(producto!=null){
            producto.setStock(stock);
            return ResponseEntity.ok(productoService.saveProducto(producto));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de producto ingresado no existe.");
        }
    }

    @PutMapping(value = "/producto/updatename")
    public ResponseEntity<?> updateNameProducto(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "nombre") String nombre) {

        Producto producto = productoService.getProductoById(id);

        if(producto!=null){
            producto.setNombre(nombre);
            return ResponseEntity.ok(productoService.saveProducto(producto));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El id de producto ingresado no existe.");
        }
    }

    @DeleteMapping(value = "/producto/{id}")
    public ResponseEntity<?> deleteProductoById(@PathVariable(value="id") long id) {

        Producto producto = productoService.getProductoById(id);

        if(producto!=null){
            if(productoService.deleteProductoById(id)){
                return ResponseEntity.ok("El producto fue eliminado exitosamente");
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("El producto no pudo ser eliminado.");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El producto que intenta eliminar no existe.");
        }
    }

}
