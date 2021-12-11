package com.mutual.SpringApiJwt.persistence.entity;

import javax.persistence.*;
import java.util.List;


/*
* La anotacion Entity nos permite entender que
* la clase Producto se comportara como una clase
* mapeada de la base de datos*/
@Entity
@Table( name = "productos")
public class Producto {

    @Id
    //Estrategia de Primary y identidades con el ID->Index
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "codigo_barras")
    private Integer codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /**
     * Relacionamos name = idTable
     * example:
     *      name = id_categoria
     *   many Prodructs --> one category
     *
     * Map relationships between classes
     *
     * permisos:
     * NO vamos ni actualizar, ni borrar o actualizar una nueva categoria
     * */
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    /**
     * @Mappings({
     *             @Mapping(source = "idProducto", target = "productId"),
     *             @Mapping(source = "nombre", target = "name"),
     *             @Mapping(source = "idCategoria", target = "categoryId"),
     *             @Mapping(source = "precioVenta", target = "price"),
     *             @Mapping(source = "cantidadStock", target = "stock"),
     *             @Mapping(source = "estado", target = "active"),
     *             @Mapping(source = "categoria", target = "category"),
     *     })
     * */

    //*
    //
    // Get
    //  &
    // Set
    //
    // *//
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Integer getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
