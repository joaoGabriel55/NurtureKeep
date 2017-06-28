package daoImplementation;

import dao.AnimalDAO;

import modelo.Animal;

public class AnimalDAOimp extends GenericDAOimp<Animal, Integer> implements AnimalDAO {

	public AnimalDAOimp() {
		super(Animal.class);
	}
}
