package service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import model.Restaurant;

@Service
public interface IRestaurantService {
      public Restaurant addRestaurant(Restaurant res);
      public Restaurant updateRestaurant(Restaurant res,Long id);
      public ResponseEntity<Restaurant> removeRestaurant(Long id);
      public Restaurant viewRestaurantsById(Long id);
      public List<Restaurant> viewAllRestaurants();
      public List<Restaurant> viewRestaurantByItem(String itemName);
}
