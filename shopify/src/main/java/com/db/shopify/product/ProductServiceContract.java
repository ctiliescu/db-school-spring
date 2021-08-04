package com.db.shopify.product;

import java.util.List;

public interface ProductServiceContract {
    public List<Product> getAll();
    public Product getByCode(String code);
    public Product insertProduct(Product product);
    public Product updateProduct(Product product) throws IllegalAccessException, CloneNotSupportedException;
    public Product deleteProductByCode(String code);
}
