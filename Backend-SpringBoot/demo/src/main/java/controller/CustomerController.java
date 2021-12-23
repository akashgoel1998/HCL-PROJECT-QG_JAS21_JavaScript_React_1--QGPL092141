package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Customer;
import service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class CustomerController {
    @Autowired
    private CustomerService custService;
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
    	return custService.addCustomer(customer);
    }
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Long id) {
    	return custService.updateCustomer(customer, id);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Long id){
    	return custService.removeCustomer(id);
    }
    @GetMapping("/customers/{id}")
    public Customer viewCustomerById(@PathVariable Long id) {
    	return custService.viewCustomerById(id);
    }
    @GetMapping("/customers")
    public List<Customer> viewAllCustomers() {
    	return custService.viewAllCustomers();
    }
    
    
}
