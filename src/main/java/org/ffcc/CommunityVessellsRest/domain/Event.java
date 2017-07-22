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

@Entity
public class Event{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	

	private String title;
	private Date startdate;
	private Date closedate;
	private String address;
	private String avatar;
	
	@JsonFormat
	@OneToOne(mappedBy="event", cascade = CascadeType.ALL, orphanRemoval=true)	
	private EventContainer eventContainer;
	
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;

	
	
	public Event() {
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = java.sql.Date.valueOf(startdate);
	}

	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(String closedate) {
		this.closedate = java.sql.Date.valueOf(closedate);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public EventContainer getEventContainer() {
		return eventContainer;
	}

	public void setEventContainer(EventContainer eventContainer) {
		this.eventContainer = eventContainer;
	}


	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
}
