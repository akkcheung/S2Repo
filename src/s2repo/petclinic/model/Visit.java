package s2repo.petclinic.model;

import java.util.Date;


import s2repo.petclinic.model.BaseEntity;

public class Visit extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String description;
	private Integer petId;
	
	public Visit()  {
        this.date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	
	
}
