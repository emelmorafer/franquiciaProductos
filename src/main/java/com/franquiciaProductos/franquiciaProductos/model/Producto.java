package com.franquiciaProductos.franquiciaProductos.model;

import jakarta.persistence.*;

@Entity(name = "Producto")
public class Producto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nombre", nullable = true)
    public String nombre;

    @Column(name = "stock", nullable = true)
    public int stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    public Producto() {
    }

    public Producto(String nombre, int stock, Sucursal sucursal) {
        this.nombre = nombre;
        this.stock = stock;
        this.sucursal = sucursal;
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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
