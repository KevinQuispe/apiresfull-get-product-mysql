package pe.com.bcp.apiproduct.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bcp.apiproduct.dao.CustomerDao;
import pe.com.bcp.apiproduct.entity.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class customerREST {
    @Autowired()
    private CustomerDao customerDao;

    @GetMapping("/listCustomerDataBase")
    public ResponseEntity<List<Customer>> getcustomer() {
        List<Customer> listcustomers = customerDao.findAll();
        return ResponseEntity.ok(listcustomers);
    }
}
