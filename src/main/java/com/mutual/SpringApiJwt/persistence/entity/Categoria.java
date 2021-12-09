package com.mutual.SpringApiJwt.persistence.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/*
 * La anotacion Entity nos permite entender que
 * la clase Categoria se comportara como una clase
 * mapeada de la base de datos*/
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    /**
     * Relacionamos: categoria con productos
     *
     *    una categoria ---- muchos productos
     *               one to many
     *
     * example Producto.java:
     *      @ManyToOne
     *      @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
     *      private '''->Categoria<-''' categoria;
     *                                       |
     *                                      |
     *                                     V
     * */
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    //*
    //
    // Get
    //  &
    // Set
    //
    // *//

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
