package com.mutual.SpringApiJwt.persistence;

import com.mutual.SpringApiJwt.persistence.crud.ProductoCrudRepository;
import com.mutual.SpringApiJwt.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
