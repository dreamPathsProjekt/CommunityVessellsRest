package org.ffcc.CommunityVessellsRest.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
public class EventContainer{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String title;
	private String type;
	private int capacity;
	
	@JsonProperty(access=Access.READ_ONLY)
	private int availableProducts=0;
	
	
	@OneToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@OneToMany(mappedBy = "eventContainer",cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Product> products;
	
	
	
	public EventContainer() {
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailableProducts() {
		return availableProducts;
	}

	public void setAvailableProducts(int availableProducts) {
		this.availableProducts = availableProducts;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
}
