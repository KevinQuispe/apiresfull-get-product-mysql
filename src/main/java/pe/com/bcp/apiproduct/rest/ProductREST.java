package pe.com.bcp.apiproduct.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bcp.apiproduct.dao.CustomerDao;
import pe.com.bcp.apiproduct.dao.ProductsDao;
import pe.com.bcp.apiproduct.entity.Customer;
import pe.com.bcp.apiproduct.entity.Product;

import java.util.List;

@RestController //anotamos la clase con restcontroller
@RequestMapping("apirest") //endpoint principal o raiz
public class ProductREST {
    //declaracion de variables
    @Autowired
    private ProductsDao productsDao;//permite realizar la inyeccion de dependencias a la BD
    @Autowired
    private CustomerDao customerDao; //se puede llamar dentro de un solo apirest a otro enpoind

    //formas de exponer un servicio
    @GetMapping() //nos define la url base base / localhost:8080
    @RequestMapping(value = "helloworld", method = RequestMethod.GET)
    public String helloWord() {
        return "Hello world, este es mi primer servicio rest";
    }

    @GetMapping("/listProductHardCode") //responde en el endponint definido: listProductHardCode
    public ResponseEntity<Product> getProductHardCode() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Producto 1");
        product.setDescription("Description harcode 1");
        return ResponseEntity.ok(product);
    }

    //metodo get: muestra una lista de productos de la bd
    @GetMapping("/listProductDataBase")
    public ResponseEntity<List<Product>> getProductDataBase() {
        List<Product> listproducts = productsDao.findAll();
        return ResponseEntity.ok(listproducts);
    }

    @GetMapping("/listCustomerDataBase")
    public ResponseEntity<List<Customer>> getcustomer() {
        List<Customer> listcustomers = customerDao.findAll();
        return ResponseEntity.ok(listcustomers);
    }
}
