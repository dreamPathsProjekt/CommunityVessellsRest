package org.ffcc.CommunityVessellsRest.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	

	private String title;
	private Date startdate;
	private Date closedate;
	private String address;
	private String avatar;
	
	@OneToOne(optional=false)
	@JoinColumn(name = "eventContainer_id")
	//@RestResource(path = "eventContainer", rel="eventContainer")
	private EventContainer eventContainer;
	
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;

	
	
	public Event() {
		// TODO Auto-generated constructor stub
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

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getClosedate() {
		return closedate;
	}

	public void setClosedate(Date closedate) {
		this.closedate = closedate;
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
	
	
}
