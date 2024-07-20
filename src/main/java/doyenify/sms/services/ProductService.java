package doyenify.sms.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doyenify.sms.entities.product;
import doyenify.sms.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public ArrayList<product> getAllProducts() {
        return (ArrayList<product>) productRepository.findAll();
            }

    public void updateProduct(Long id, product products) throws Exception {
        var savedProduct = getProduct(id);

        if (savedProduct != null) {
            savedProduct.setPrice(products.getPrice());
            savedProduct.setDescription(products.getDescription());
            savedProduct.setName(products.getName());
            savedProduct(savedProduct);
            return;
        }
        throw new Exception("product not found");
    }

    public void savedProduct(product products) {
        productRepository.saveAndFlush(products);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
