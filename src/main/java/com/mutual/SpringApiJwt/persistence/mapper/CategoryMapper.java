package com.mutual.SpringApiJwt.persistence.mapper;

import com.mutual.SpringApiJwt.domain.Category;
import com.mutual.SpringApiJwt.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    /**
     * Vamos a covertir una Categoria a--> Category
     * Entity: Categoria --> domain:Category
     */
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "categoryId"),
            @Mapping(source = "idCategoria", target = "categoryId"),
    })
    Category toCategory(Categoria categoria);


    /**
     * Vamos a covertir una Category a--> Categoria
     * Domain:Category --> Entity: Categoria
     *
     *
     * Mapeo Inverso = Map Struct
     */
    @InheritInverseConfiguration
    @Mapping( target =  "productos", ignore = true)
    Categoria toCategoria(Category category);
}
