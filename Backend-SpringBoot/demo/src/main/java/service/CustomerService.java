package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exception.CustomerNotFoundException;
import model.Customer;
import repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository custRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return custRepository.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id)  {
		// TODO Auto-generated method stub
		Customer cust=new Customer();
		try {
			cust = (Customer) custRepository.findById(id)
					 .orElseThrow(()-> new CustomerNotFoundException("The customer not found"));
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         cust.setAddress(customer.getAddress());
         cust.setAge(customer.getAge());
         cust.setEmail(customer.getEmail());
         cust.setFirstName(cust.getFirstName());
         cust.setLastName(customer.getLastName());
         cust.setMobileNumber(customer.getMobileNumber());
         cust.setGender(customer.getGender());
         return this.custRepository.save(cust);
	}

	@Override
	public ResponseEntity<Customer> removeCustomer(Long id) {
		// TODO Auto-generated method stub
		Customer cust=new Customer();
		try {
			cust=(Customer) custRepository.findById(id)
					.orElseThrow(()->new CustomerNotFoundException("The customer Not found"));
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.custRepository.delete(cust);
		return ResponseEntity.ok().build();
	
	}

	@Override
	public Customer viewCustomerById(Long id) {
		// TODO Auto-generated method stub
		Customer cust=new Customer();
		try {
			cust=custRepository.findById(id)
					.orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return this.custRepository.findAll();
	}

	
       
}
