package com.mutual.SpringApiJwt.persistence;

import com.mutual.SpringApiJwt.domain.Product;
import com.mutual.SpringApiJwt.domain.repository.ProductRepository;
import com.mutual.SpringApiJwt.persistence.crud.ProductoCrudRepository;
import com.mutual.SpringApiJwt.persistence.entity.Producto;
import com.mutual.SpringApiJwt.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Repository
 * Esta es la clase que interactua con la DB
 * */
@Repository
public class ProductoRepository implements ProductRepository {


    @Autowired
    private ProductoCrudRepository productoCrudRepository;


    //Varaible de MapStruct
    @Autowired
    private ProductMapper mapper;



    @Override
    public List<Product> getAll(){
        /***
         * mapper:ProductMapper
         * List<Product> toProducts(List<Producto>productos);
         */
        List<Producto>productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List <Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map( prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId)
                .map(
                        producto -> mapper.toProduct(producto)
                );
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    /**
     * Query Methods
     */

    //Reto#1
    public Optional<List<Producto>> getProductoByPrecioVentaLessThanPriceAndByCategory (int precioVenta, int idCategoria) {
        return productoCrudRepository.findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(precioVenta, idCategoria);
    }


    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
