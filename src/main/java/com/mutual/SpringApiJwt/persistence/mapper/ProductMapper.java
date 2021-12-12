package com.mutual.SpringApiJwt.persistence.mapper;

import com.mutual.SpringApiJwt.domain.Product;
import com.mutual.SpringApiJwt.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


/**
 * Covertira la categoria a category
 *
 * @Mapping(source = "categoria", target = "category")
 *                                      /
 *   Importante:                       /
 *   Tambien nos permite usarlo       /
 *   con el @Autowired               V
 * */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    /**
     * Vamos a covertir un Producto a--> Product
     * Entity: Producto --> domain:Product
     */
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto>productos);


    /**
     * Vamos a covertir una Category a--> Categoria
     * Domain:Category --> Entity: Categoria
     *
     *
     * Mapeo Inverso = Map Struct
     */
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
