package com.kevinpina.controllers;

import com.kevinpina.entities.Product;
import com.kevinpina.services.ProductService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

//@Named("productController") // The name value by the default is the name of the class
//@RequestScoped
@Model // @Model resume the use of @Name "by default the name of class" and @RequestScope
       // in this case in webapp/form.xhtml <h:commandButton value="Create" action="#{productController.save}" /> ...
@Slf4j
public class ProductController {

    //private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    private Product product;

    @Getter
    @Setter
    private Long id;

    @Inject
    private ProductService productService;

    @Produces // Registering in CDI to be retrive from the view
    @Model // @Model resume the use of @Name "by default the name of method" and @RequestScope
    public String title() {
        return "Index JakartaEE10 JSF";
    }

    @Produces // Registering in CDI to be retrive from the view
    @Named("h1")
    @RequestScoped
    public String header1() {
        return "Index JakartaEE10 JSF";
    }

    @Produces
    @Named("productList")
    @RequestScoped
    public List<Product> getProducts() {
        // return Stream.of(new Product("Apple"), new Product("Orange"), new Product("Lemon")).toList();

        List<Product> products = productService.listProducts();

        log.info("--- Total Size: {}", products.size());
        products.forEach(p -> log.info(p.getName()));

        return products;
    }

    @Produces // Registering in CDI to be retrive from the view
    @Model // @Model resume the use of @Name "by default the name of method" and @RequestScope
           // in this case in webapp/form.xhtml <h:inputText id="name" value="#{product.name}" /> ...
    public Product product() {
        product = new Product();
        if (id != null && id > 0) {
            // product = productService.getProduct(id).orElseThrow();
            productService.getProduct(id).ifPresent(p -> product = p);
        }
        return product;
    }

    public String save() {
        log.info("--- {}", product);
        productService.save(product);
        return "index.xhtml?faces-redirect=true";
    }

    public String edit(Long id) {
        this.id = id;
        return "form.xhtml";
    }

    public String delete(Long id) {
        productService.delete(id);
        return "index.xhtml?faces-redirect=true";
    }

}
