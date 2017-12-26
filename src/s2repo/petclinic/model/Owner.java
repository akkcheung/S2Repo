package s2repo.petclinic.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Owner extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String address;
	private String city;
	private String telephone;

	private Set<Pet> pets;

	protected Set<Pet> getPetsInternal() {
		if (this.pets == null) {
			this.pets = new HashSet<>();
		}
		return this.pets;
	}

	protected void setPetsInternal(Set<Pet> pets) {
		this.pets = pets;
	}

	public List<Pet> getPets() {
		List<Pet> sortedPets = new ArrayList<>(getPetsInternal());

		// Todo
		// PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true,
		// true));
		// return Collections.unmodifiableList(sortedPets);

		return null;
	}

	public void addPet(Pet pet) {
		// Todo
		// if (pet.isNew()) {
		// getPetsInternal().add(pet);
		// }
		pet.setOwner(this);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

}
