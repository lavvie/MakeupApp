package info.lavenderdawn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Collection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long collectionId;
	private String category; 
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			   fetch = FetchType.LAZY)
	@JoinTable(name="collection_product",
	joinColumns=@JoinColumn(name="collection_id"),
	inverseJoinColumns= @JoinColumn(name="product_id") 

			)
	private List<Product>products;
	
	public Collection() {
		
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Collection(String category, List<Product> products) {
		super();
		this.category = category;
		this.products = products;
	}


		
}