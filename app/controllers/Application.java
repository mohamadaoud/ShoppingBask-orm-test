package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.Category;
import models.Product;
import models.ShoppingBasket;
import models.User;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	public static Result createSomeData() {
		
		Product product = new Product(3, "Volvo", "2009 manual car", 10000.0);
		Ebean.save(product);
		
		Category category = new Category(3, "Animals", "Cat, Dog, Wolf");
		Ebean.save(category);
		
		User user = new User(2, "AbC1D", "Khalid", "Daoud", "Sundbyberg, Stockholm", "0720016684", "daoud_mohamad@yahoo.co.uk");
		Ebean.save(user);
		
		ShoppingBasket shoppingBasket = new ShoppingBasket(1, 10);
		Ebean.save(shoppingBasket);
		
		return ok("Data created");
	}

    public static Result index() {
    	
    	List<Product> products = Ebean.find(Product.class).findList();
    	List<Category> categories = Ebean.find(Category.class).findList();
    	List<User> users = Ebean.find(User.class).findList();
    	List<ShoppingBasket> shopping = Ebean.find(ShoppingBasket.class).findList();
        return ok(index.render(products, categories, users, shopping));
    }
    
    public static Result showProduct(int id) {
    	Product product = Ebean.find(Product.class, id);
    	
    	return ok(showProduct.render(product));
    }
    
    public static Result showCategory(int id) {
    	
    	Category category = Ebean.find(Category.class, id);
    	
    	return ok(showCategory.render(category));
    }
    
    public static Result showUser(int id) {
    	
    	User user = Ebean.find(User.class, id);
    	
    	return ok(showUser.render(user));
    }
    
    public static Result showShoppingBasket(int id) {
    	
    	ShoppingBasket shoppingBasket = Ebean.find(ShoppingBasket.class, id);
    	return ok(showShoppingBasket.render(shoppingBasket));
    }

}