package org.ffcc.CommunityVessellsRest.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class ExpireOps {
//Class ExpireOps has expiry date so is used for Food  and Pharm Products

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date expire;

	@JsonProperty(access = Access.READ_ONLY)
	private String isExpired;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public ExpireOps() {
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = java.sql.Date.valueOf(expire);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public String getIsExpired() {
		return isExpired;
	}

	public void setIsExpired() {
		if(this.expire.before(new java.sql.Date(new java.util.Date().getTime())))
			this.isExpired = "Yes";
		else
			this.isExpired = "No";
		
	}
	
	
}
