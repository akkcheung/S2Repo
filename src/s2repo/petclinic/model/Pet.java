package s2repo.petclinic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


import s2repo.petclinic.model.NamedEntity;
import s2repo.petclinic.model.Visit;

public class Pet extends NamedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date birthday;  //datetime
	
	private PetType type;
	private Owner owner;

	private Set<Visit> visits = new LinkedHashSet<>();
	
	public Set <Visit> getVisits() {
		return this.visits;
	}

	public void addVisit(Visit visit) {
		getVisitsInternal().add(visit);
		visit.setPetId(this.getId());
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	protected Set<Visit> getVisitsInternal() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	protected void setVisitsInternal(Set<Visit> visits) {
		this.visits = visits;
	}
}
