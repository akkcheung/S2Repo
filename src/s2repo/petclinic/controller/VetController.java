package s2repo.petclinic.controller;

import java.util.List;
import java.util.Set;

import org.skife.jdbi.v2.DBI;

import com.opensymphony.xwork2.ActionSupport;

import s2repo.petclinic.dao.VetDao;
import s2repo.petclinic.model.Specialty;
import s2repo.petclinic.model.Vet;
import s2repo.petclinic.util.DataSourceFactory;

public class VetController extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List <Vet> vets;
	private String lastName;
	
	public String search() {
		
		DBI dbi = new DBI(DataSourceFactory.getH2PetClinicDataSource());		
		VetDao vetDao = dbi.onDemand(VetDao.class);
		
		vets = vetDao.search("%" + lastName + "%");
		
		System.out.println(vets.size());
		
		Vet vet;
		Set <Specialty> specialties;
		
		for (int i=0; i<vets.size() ; i++) {
			System.out.println(vets.get(i).getLastName());
			
			specialties = vets.get(i).getSpecialties();
			
			for (int j=0; j<specialties.size(); j++) {
				// System.out.println(specialties..getName());
			}
		}
		
		
		
		return SUCCESS;
		
	}

	public List<Vet> getVets() {
		return vets;
	}

	public void setVets(List<Vet> vets) {
		this.vets = vets;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
