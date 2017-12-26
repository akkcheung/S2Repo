package s2repo.petclinic.controller;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import com.opensymphony.xwork2.ActionSupport;

import s2repo.petclinic.util.DataSourceFactory;

import s2repo.petclinic.model.Owner;
import s2repo.petclinic.dao.OwnerDao;

public class OwnerController extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<Owner> result ;
	
//	private String type; //json
	
	private String lastName;
	
	private int id;
	
	private Owner owner;
	
	public String list()  {
	
			DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());		
			
			OwnerDao dao = dbi.onDemand(OwnerDao.class);
			
			setResult(dao.listAll());
			
			return SUCCESS;
	}
	
	public String search() {
		
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());		
		OwnerDao dao = dbi.onDemand(OwnerDao.class);
		
		setResult(dao.search("%" + lastName + "%"));
		
		return SUCCESS;
		
	}

	public String edit() {
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());		
		OwnerDao dao = dbi.onDemand(OwnerDao.class);
		setOwner(dao.findById(id));
		
		return SUCCESS;
	}

	public String change() {
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());		
		OwnerDao dao = dbi.onDemand(OwnerDao.class);
		
		// System.out.println("id :" +owner.getId());
		
		int i;
		
		if (owner.getId() == null) {			
			i=dao.insert(owner);
		} else {
			i= dao.update(owner);
		}
		
		if (i>0) 
			addActionMessage("Record is saved !");
		
		return SUCCESS;
	}
	
	public List<Owner> getResult() {
		return result;
	}


	public void setResult(List<Owner> result) {
		this.result = result;
	}

//	public String getType() {
//		return type;
//	}
//
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
