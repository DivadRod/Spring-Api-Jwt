package com.mutual.SpringApiJwt.persistence.crud;

import com.mutual.SpringApiJwt.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

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

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
