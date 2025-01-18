package com.franquiciaProductos.franquiciaProductos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Sucursal")
public class Sucursal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombre", nullable = true)
    public String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;

    public Sucursal() {
    }

    public Sucursal(String nombre, Franquicia franquicia) {
        this.nombre = nombre;
        this.franquicia = franquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }
}
