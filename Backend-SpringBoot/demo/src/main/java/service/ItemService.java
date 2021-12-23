package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exception.ItemNotFoundException;
import model.Item;
import model.Restaurant;
import repository.ItemRepository;

@Service
public class ItemService implements IItemService{
	@Autowired
	private ItemRepository itemRepository;
	@Override
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}
	@Override
	public Item updateItem(Item item,Long id) {
		Item i=new Item();
		try {
		     i=itemRepository.findById(id)
					.orElseThrow(()->new ItemNotFoundException("Item not found"));
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i.setCost(item.getCost());
		i.setItemName(item.getItemName());
		i.setQuantity(item.getQuantity());
		i.setRes(item.getRes());
		return itemRepository.save(i);
	}
	@Override
	public ResponseEntity<Item> removeItem(Long id){
		Item i=new Item();
		try {
		     i=itemRepository.findById(id)
					.orElseThrow(()->new ItemNotFoundException("Item not found"));
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		itemRepository.delete(i);
		return ResponseEntity.ok().build();
	}
	@Override
	public Item viewItemById(Long id) {
		Item i=new Item();
		try {
		     i=itemRepository.findById(id)
					.orElseThrow(()->new ItemNotFoundException("Item not found"));
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public List<Item> viewAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}
	@Override
	public List<Item> viewItemsByRestaurant(String resName){
		List<Item> items=new ArrayList<Item>();
		List<Item> i=itemRepository.findAll();
	
		for(Item item:i) {
			List<Restaurant> r=item.getRes();
			for(Restaurant resItem:r) {
				if(resItem.getRestaurantName().equals(resName))
					items.add(item);
			}
			
		}
		return items;
	}

}
