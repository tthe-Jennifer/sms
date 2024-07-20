package doyenify.sms.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import doyenify.sms.services.ProductService;

@RestController
public class productController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    // For a simple description of Java Lambda expressions
    // https://www.w3schools.com/java/java_lambda.asp

    @GetMapping("/products/{id}")
    public product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    // Here we use products, an ArrayList, as a source for a stream, and then
    // perform a filter-map
    // on the stream to obtain the first element that has the same passed id, then,
    // returns it.

    @PostMapping("/products")
    public void addProduct(@RequestBody product product) {
        productService.savedProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody product product, @PathVariable Long id) throws Exception {
        productService.updateProduct(id, product);
    }

    // size() is a method implemented by all members of Collection (lists, sets,
    // stacks,...). It returns
    // the number of elements the collection contains.

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
