package com.mutual.SpringApiJwt.persistence.crud;

import com.mutual.SpringApiJwt.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Extiende de la libreria
 *
 * org.springframework.data.repository.CrudRepository
 *
 * por lo cual tiene atributos
 *          save()
 *          saveAll()
 *          findById()
 *          existsById()
 *          findAll()
 *          findAllById = nos devuelve toda un lista que pertenezca a una llave primaria
 *          Count()
 *          deleteById()
 *          delete()
 *          deleteAll()
 * */


                                                //@Autowired
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Convencional
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)

    //Forma nativa
    List<Producto> findByIdCategoria(int idCategoria);

    //Forma nativa
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    //Reto1
    Optional<List<Producto>> findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(int precioVenta, int idCategoria);

}
