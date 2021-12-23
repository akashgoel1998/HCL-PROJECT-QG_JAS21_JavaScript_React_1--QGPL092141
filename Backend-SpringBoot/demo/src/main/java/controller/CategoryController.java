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

import model.Category;
import service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	private CategoryService catService;
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category cat) {
		return catService.addCategory(cat);
	}
	@PutMapping("/category/{id}")
	public Category updateCategory(@RequestBody Category cat, @PathVariable Long id) {
		return catService.updateCategory(cat, id);
	}
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Category> removeCategory(@PathVariable Long id) {
		return catService.removeCategory(id);
		
	}
	@GetMapping("/category/{id}")
	public Category viewCategoryById(@PathVariable Long id) {
		return catService.viewCategoryById(id);
	}
	@GetMapping("/category")
	public List<Category> viewAllCategories() {
		return catService.viewAllCategories();
	}

}
