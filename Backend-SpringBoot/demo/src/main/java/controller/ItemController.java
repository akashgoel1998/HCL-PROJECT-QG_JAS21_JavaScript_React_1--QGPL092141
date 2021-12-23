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

import model.Item;
import service.ItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	@PutMapping("/items/{id}")
	public Item updateItem(@RequestBody Item item,@PathVariable Long id) {
		return itemService.updateItem(item, id);
	}
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Item> removeItem(@PathVariable Long id){
		return itemService.removeItem(id);
	}
	@GetMapping("/items/{id}")
	public Item viewItemById(Long id) {
		return itemService.viewItemById(id);
	}
	@GetMapping("/items")
	public List<Item> viewAllItems(){
		return itemService.viewAllItems();
	}
	@GetMapping("/items/{resName}")
	public List<Item> viewItemsByRestaurant(@PathVariable String resName){
		return itemService.viewItemsByRestaurant(resName);
	}
	
	

}
