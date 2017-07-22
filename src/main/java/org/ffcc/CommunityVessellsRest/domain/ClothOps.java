package org.ffcc.CommunityVessellsRest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class ClothOps {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String clotheCondition;
	private String size;

	@JsonProperty(access=Access.READ_ONLY)
	private String isFubar;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public ClothOps() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClotheCondition() {
		return clotheCondition;
	}

	public void setClotheCondition(String clotheCondition) {
		this.clotheCondition = clotheCondition;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIsFubar() {
		return isFubar;
	}

	public void setIsFubar() {
		if(this.clotheCondition.equals("Fubar"))
			this.isFubar = "Yes";
		else this.isFubar = "No";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
