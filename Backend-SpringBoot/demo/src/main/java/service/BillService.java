package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exception.BillNotFoundException;

import model.Bill;

import repository.BillRepository;

@Service
public class BillService {
     @Autowired
     private BillRepository bRepository;
     public Bill addBill(Bill bill) {
    	 return bRepository.save(bill);
     }
     public Bill updateBill(Bill bill,Long id) {
    	Bill b=new Bill();
 		try {
 			b = (Bill) bRepository.findById(id)
 					 .orElseThrow(()-> new BillNotFoundException("The Bill not found"));
 		} catch (BillNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		b.setBillDate(bill.getBillDate());
 		b.setOrder(bill.getOrder());
 		b.setTotalCost(bill.getTotalCost());
 		b.setTotalItem(bill.getTotalItem());
 		return bRepository.save(b);
     }
     public ResponseEntity<Bill> removeBill(Long id){
    	 Bill b=new Bill();
  		try {
  			b = (Bill) bRepository.findById(id)
  					 .orElseThrow(()-> new BillNotFoundException("The Bill not found"));
  		} catch (BillNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		bRepository.delete(b);
  		return ResponseEntity.ok().build();
     }
     public Bill viewBillsById(Long id) {
    	 Bill b=new Bill();
   		try {
   			b = (Bill) bRepository.findById(id)
   					 .orElseThrow(()-> new BillNotFoundException("The Bill not found"));
   		} catch (BillNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return b;
     }
     public List<Bill> viewAllBills(){
    	 return bRepository.findAll();
     }
}
