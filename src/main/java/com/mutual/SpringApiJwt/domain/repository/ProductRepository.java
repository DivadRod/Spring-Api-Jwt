package com.mutual.SpringApiJwt.domain.repository;

import com.mutual.SpringApiJwt.domain.Product;

import java.util.List;
import java.util.Optional;
/**
 * @Autowired
 * @Repository
 * public class ProductoRepository implements ProductRepository
 * */
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
