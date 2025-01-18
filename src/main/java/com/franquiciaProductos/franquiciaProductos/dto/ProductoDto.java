package com.franquiciaProductos.franquiciaProductos.dto;

public class ProductoDto {

    public Long id;

    public String nombre;

    public int stock;

    public Long sucursal_id;

    public ProductoDto() {
    }

    public ProductoDto(Long id, String nombre, int stock, Long sucursal_id) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.sucursal_id = sucursal_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(Long sucursal_id) {
        this.sucursal_id = sucursal_id;
    }
}
