package repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.FoodCart;
@Repository
public interface CartRepository extends JpaRepository<FoodCart,Long>{

}
