package info.lavenderdawn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import info.lavenderdawn.dao.ProductRepository;
import info.lavenderdawn.dto.CollectionProduct;

@Controller
public class HomeController {

	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/")
	public String listProducts(Model model) {
		
		List<CollectionProduct>collectionProducts = productRepository.collectionProducts();
		model.addAttribute("CollectionProduct", collectionProducts);
		
		
		return "main/home";
	}

}

