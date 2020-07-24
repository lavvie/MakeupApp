package info.lavenderdawn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.lavenderdawn.dao.CollectionRepository;
import info.lavenderdawn.entities.Collection;

@Controller
@RequestMapping("/collections")
public class CollectionController {

	@Autowired
	CollectionRepository collectionRepository;
	
	@GetMapping
	public String displayCollections(Model model) {
		
		List<Collection> collections = collectionRepository.findAll();
		model.addAttribute("collections", collections);
		
		return "collections/list-collections";
	}
	
	@GetMapping("/new")
	public String displayCollectionForm(Model model) {
		
		Collection aCollection = new Collection();
		model.addAttribute("collection", aCollection);
		
		return "collections/new-collection";
	}
	
	@PostMapping("/save")
	public String createCollection (Collection collection, Model model) {
		
		collectionRepository.save(collection);
		
		return "redirect:/collections";
	}
	
	@GetMapping("/update")
	public String displayCollectionUpdateForm(@RequestParam("id")long theId, Model model) {
		
		Collection theCol = collectionRepository.findByCollectionId(theId);
		model.addAttribute("collection", theCol);
		
		return "collections/new-collection";
	}
	
	@GetMapping("delete")
	public String deleteCollection(@RequestParam("id") long theId, Model model) {
		
		Collection theCol = collectionRepository.findByCollectionId(theId);
		collectionRepository.delete(theCol);
		
		return "redirect:/collections";
	}
}