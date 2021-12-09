package com.mutual.SpringApiJwt.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;


    /**
     * Relacionamos name = idTable
     * example:
     *      name = id_cliente
     * permisos:
     *      * NO vamos ni actualizar, ni borrar un CLIENTE
     *
     *
     *                   Muchos a uno
     *      *           Many  To   One
     *      *  Muchas compras un cliente

     * */
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;


    /**
     * Toda LA LISTA DE  UNA COMPRA
     * ComprasProducto.java
     *
     * example ComprasProducto.java:
     *      *      @ManyToOne
     *             @JoinColumn(name = "id_productp",insertable = false, updatable = false)
     *             private Producto producto;
     *      *                         |
     *      *                       |
     *      *                      V
    * */
    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;


    //*
    //
    // Get
    //  &
    // Set
    //
    // *//

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
