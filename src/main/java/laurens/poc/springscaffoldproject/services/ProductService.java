package laurens.poc.springscaffoldproject.services;

import laurens.poc.springscaffoldproject.entities.Product;
import laurens.poc.springscaffoldproject.exceptions.ProductException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private List<Product> productList;

    @PostConstruct
    private void init(){
        productList = new ArrayList<>(Arrays.asList(
            Product.builder().id(1).name("Jabon").price(3400).build(),
            Product.builder().id(2).name("Cafe").price(2500).build(),
            Product.builder().id(3).name("Mani").price(1230).build(),
            Product.builder().id(4).name("Leche").price(5600).build()
        ));
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public Product getProductByid(int idProduct){
        return productList.stream()
                .filter(x -> x.getId() == idProduct).findFirst()
                .orElseThrow(() -> new ProductException(ProductException.Type.PRODUCT_NOTFOUND));
    }

    public Product addProduct(Product product){
        product.setId(productList.get(productList.size() -1).getId() + 1);
        productList.add(product);
        return product;
    }

    public String deleteProduct(int idProduct){
        Optional<Product> optionalProduct = productList.stream()
                .filter(x -> x.getId() == idProduct).findFirst();

        if(optionalProduct.isEmpty()){
            throw new ProductException(ProductException.Type.PRODUCT_NOTFOUND);
        }

        productList.remove(optionalProduct.get());

        return String.format("Product with ID %s was deleted", idProduct);
    }

    public Product modifyProduct(int idProduct, Product product){
        Optional<Product> optionalProduct = productList.stream()
                .filter(x -> x.getId() == idProduct).findFirst();

        if(optionalProduct.isEmpty()){
            throw new ProductException(ProductException.Type.PRODUCT_NOTFOUND);
        }

        this.toObject(product, optionalProduct.get());

        return optionalProduct.get();
    }

    private void toObject(Product origen, Product destino){
        destino.setName(origen.getName());
        destino.setPrice(origen.getPrice());
    }

}
