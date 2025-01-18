package com.franquiciaProductos.franquiciaProductos.dto;

public class SucursalDto {

    public Long id;

    public String nombre;

    public Long franquicia_id;

    public SucursalDto() {
    }

    public SucursalDto(Long id, String nombre, Long franquicia_id) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia_id = franquicia_id;
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

    public Long getFranquicia_id() {
        return franquicia_id;
    }

    public void setFranquicia_id(Long franquicia_id) {
        this.franquicia_id = franquicia_id;
    }
}
