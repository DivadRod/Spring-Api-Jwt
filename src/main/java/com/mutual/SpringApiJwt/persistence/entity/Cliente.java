package com.mutual.SpringApiJwt.persistence.entity;

import javax.persistence.*;
import java.util.List;

/*
 * La anotacion Entity nos permite entender que
 * la clase Categoria se comportara como una clase
 * mapeada de la base de datos*/
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    /**
     * Relacionamos: cliente con compra
     *
     *    un cliente ---- muchas compras
     *              one to many
     *
     * example Compra.java:
     *      @ManyToOne
     *      @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
     *                     private Cliente cliente;
     *                                       |
     *                                      |
     *                                     V
     * */
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    //*
    //
    // Get
    //  &
    // Set
    //
    // *//


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

}
