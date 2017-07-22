package org.ffcc.CommunityVessellsRest.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@JsonProperty(access=Access.READ_ONLY)
	private String email; //The email of the volunteer that promises the product.
	private int count;
	private String title;
	
	@JsonProperty(access=Access.READ_ONLY)
	private String type;
	
	@JsonProperty(access=Access.READ_ONLY)
	private Date dateStored;
	
	@JsonProperty(access=Access.READ_ONLY)
	private String isPromised; //pseudo boolean "Yes" "No".
	
	@JsonFormat
	@OneToOne(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval=true)
	private ExpireOps expireOps;
	
	
	@JsonFormat
	@OneToOne(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval=true)
	private ClothOps clothOps;
	
	
	@ManyToOne
	@JoinColumn(name="eventContainer_id")
	private EventContainer eventContainer;

	@ManyToOne
	@JoinColumn(name="volunteer_id")
	private Volunteer volunteer;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateStored() {
		return dateStored;
	}

	public void setDateStored(Date dateStored) {
		this.dateStored = dateStored;
	}

	

	public String getIsPromised() {
		return isPromised;
	}

	public void setIsPromised(String isPromised) {
		this.isPromised = isPromised;
	}

	public ClothOps getClothOps() {
		return clothOps;
	}

	public void setClothOps(ClothOps clothOps) {
		this.clothOps = clothOps;
	}

	public ExpireOps getExpireOps() {
		return expireOps;
	}

	public void setExpireOps(ExpireOps expireOps) {
		this.expireOps = expireOps;
	}


	public EventContainer getEventContainer() {
		return eventContainer;
	}

	public void setEventContainer(EventContainer eventContainer) {
		this.eventContainer = eventContainer;
	}

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	
	
}
