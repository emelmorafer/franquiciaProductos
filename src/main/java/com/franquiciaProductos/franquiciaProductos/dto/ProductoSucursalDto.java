package com.franquiciaProductos.franquiciaProductos.dto;

public class ProductoSucursalDto {

    public String nombreProducto;

    public String nombreSucursal;

    public ProductoSucursalDto() {
    }

    public ProductoSucursalDto(String nombreProducto, String nombreSucursal) {
        this.nombreProducto = nombreProducto;
        this.nombreSucursal = nombreSucursal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
}
