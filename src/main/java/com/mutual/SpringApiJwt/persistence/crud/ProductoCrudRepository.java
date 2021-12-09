package com.mutual.SpringApiJwt.persistence.crud;

import com.mutual.SpringApiJwt.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
