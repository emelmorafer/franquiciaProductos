package com.franquiciaProductos.franquiciaProductos.dto;

public class FranquiciaDto {

    public Long id;

    public String nombre;

    public FranquiciaDto() {
    }

    public FranquiciaDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
