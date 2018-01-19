package s2repo.petclinic.controller;

import java.util.List;

import org.skife.jdbi.v2.DBI;

import com.opensymphony.xwork2.ActionSupport;

import s2repo.petclinic.dao.OwnerDao;
import s2repo.petclinic.dao.PetDao;
import s2repo.petclinic.dao.PetTypeDao;
import s2repo.petclinic.dao.VisitDao;
import s2repo.petclinic.model.Owner;
import s2repo.petclinic.model.Pet;
import s2repo.petclinic.model.Visit;
import s2repo.petclinic.util.DataSourceFactory;

public class VisitController  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private Visit visit;
	
	private int petId;
	private int ownerId;
	
	private Owner owner;	
	private Pet pet;	
	private List visits;
	
	private String _method ; // intercooler Js parameter
	
	public String newVisit() {
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());	
		
		OwnerDao ownerDao = dbi.onDemand(OwnerDao.class);		
		owner = ownerDao.findById(ownerId);
				
		PetDao petDao= dbi.onDemand(PetDao.class) ;
		pet = petDao.findById(petId);
		
		// System.out.println("> pet name" + pet.getName());
		
		VisitDao visitDao= dbi.onDemand(VisitDao.class) ;
		List <Visit> visits = visitDao.listByPetId(pet.getId()); 
		
		//System.out.println("> previous visits " + visits.size());
		
		for (int i=0 ; i < visits.size(); i++)
		{
			pet.addVisit(visits.get(i));
			
			// System.out.println("> visit description " + pet.getVisits().get(i).getDescription());
		}
		
		// System.out.println("> pet visits " + pet.getVisits().size());
		
		return SUCCESS;
	}
	
	public String edit() {
		
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());
		
		VisitDao visitDao = dbi.onDemand(VisitDao.class);		
		visit = visitDao.findById(id);
		
		return SUCCESS;
	}
	
	public String change() {
		
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());
		
		VisitDao visitDao = dbi.onDemand(VisitDao.class);
		
		int i;
		if (visit.getId() == null) {			
			i =visitDao.insert(visit.getDate(), visit.getDescription(), pet.getId());
		} else {
			i= visitDao.update(visit.getDate(), visit.getDescription(), pet.getId(), visit.getId());
		}
		
		if (i>0) 
			addActionMessage("Record is saved !");
		
		return SUCCESS;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List getVisits() {
		return visits;
	}

	public void setVisits(List visits) {
		this.visits = visits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String get_method() {
		return _method;
	}

	public void set_method(String _method) {
		this._method = _method;
	}
	
	
}