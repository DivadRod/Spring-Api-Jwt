package com.mutual.SpringApiJwt.persistence;

import com.mutual.SpringApiJwt.persistence.crud.ProductoCrudRepository;
import com.mutual.SpringApiJwt.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Repository
 * Esta es la clase que interactua con la DB
 * */
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }


    /**
     * Query Methods
     */
    public List<Producto>getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //Reto#1
    public Optional<List<Producto>> getProductoByPrecioVentaLessThanPriceAndByCategory (int precioVenta, int idCategoria) {
        return productoCrudRepository.findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(precioVenta, idCategoria);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
