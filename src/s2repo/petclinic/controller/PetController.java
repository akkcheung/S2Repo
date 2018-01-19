package s2repo.petclinic.controller;


import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.DBI;

import com.opensymphony.xwork2.ActionSupport;

import s2repo.petclinic.model.Owner;
import s2repo.petclinic.model.Pet;
import s2repo.petclinic.util.DataSourceFactory;

import s2repo.petclinic.dao.PetTypeDao;
import s2repo.petclinic.dao.OwnerDao;
import s2repo.petclinic.dao.PetDao;

public class PetController  extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private Pet pet;
	
	private int ownerId;
	
	private Owner owner;	
	private List<?> petTypes;
	
	private String _method ; // intercooler Js parameter
	
	public String newPet() {
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());	
		
		OwnerDao ownerDao = dbi.onDemand(OwnerDao.class);		
		owner = ownerDao.findById(ownerId);
		
		PetTypeDao petTypeDao = dbi.onDemand(PetTypeDao.class);
		petTypes = petTypeDao.listAll();
		
		return SUCCESS;
	}
	
	public String edit() {
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());
		
		OwnerDao ownerDao = dbi.onDemand(OwnerDao.class);		
		owner = ownerDao.findById(ownerId);
	
		PetDao petDao = dbi.onDemand(PetDao.class);		
		pet = petDao.findById(id);

		PetTypeDao petTypeDao = dbi.onDemand(PetTypeDao.class);
		petTypes = petTypeDao.listAll();

		return SUCCESS;
	}

	public String change() {
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());	
		PetDao petDao = dbi.onDemand(PetDao.class);
		
//		System.out.println("> pet.owner.id :" + pet.getOwner().getId());
//		System.out.println("> pet.type.id : " + pet.getType().getId());
//		
//		System.out.println("> pet.name : " + pet.getName());
		
		// pet.setBirthday(new Date());
//		System.out.println("> pet.birthday : " + pet.getBirthday());
		
		int i=0;
				
		if (pet.getId() == null) {
			i = petDao.insert(pet.getName(), pet.getBirthday(), pet.getType().getId(), pet.getOwner().getId());
		} else {
			i = petDao.update(pet.getName(), pet.getBirthday(), pet.getType().getId(), pet.getId());
			// System.out.println("> update pet");
		}
		
		if (i>0) 
			addActionMessage("Record is saved !");
		
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List getPetTypes() {
		return petTypes;
	}

	public void setPetTypes(List petTypes) {
		this.petTypes = petTypes;
	}

	public String get_method() {
		return _method;
	}

	public void set_method(String _method) {
		this._method = _method;
	}
	
	
}
