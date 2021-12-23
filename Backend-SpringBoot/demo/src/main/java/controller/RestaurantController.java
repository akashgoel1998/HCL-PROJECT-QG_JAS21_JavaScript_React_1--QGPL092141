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

import model.Restaurant;
import service.RestaurantService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class RestaurantController {
	@Autowired
	private RestaurantService resService;
	@PostMapping("/restaurants")
	public Restaurant addRestaurant(@RequestBody Restaurant res) {
		return resService.addRestaurant(res);
	}
	@PutMapping("/restaurants/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant res,@PathVariable Long id) {
		return resService.updateRestaurant(res, id);
	}
	@DeleteMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> removeRestaurant(@PathVariable Long id) {
		return resService.removeRestaurant(id);
	}
	@GetMapping("restaurants/{id}")
	public Restaurant viewRestaurantsById(@PathVariable Long id) {
		return resService.viewRestaurantsById(id);
	}
	@GetMapping("restaurants")
	public List<Restaurant> viewAllRestaurants(){
		return resService.viewAllRestaurants();
	}
	@GetMapping("restaurants/{itemName}")
	public List<Restaurant> viewRestaurantByItem(@PathVariable String itemName){
		return resService.viewRestaurantByItem(itemName);
	}

}
