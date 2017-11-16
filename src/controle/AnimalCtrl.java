package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AnimalDAO;
import daoImplementation.AnimalDAOimp;

import modelo.Animal;

@ManagedBean
@SessionScoped
public class AnimalCtrl {

	private Animal animal;
	private List<Animal> listaAnimal;

	public AnimalCtrl() {
		this.animal = new Animal();
		AnimalDAO animaldao = new AnimalDAOimp();
		this.listaAnimal = animaldao.listAll();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Animal> getListaAnimal() {
		AnimalDAO animaldao = new AnimalDAOimp();
		this.listaAnimal = animaldao.listAll();

		return listaAnimal;
	}

	public void setListaAnimal(List<Animal> listaAnimal) {
		this.listaAnimal = listaAnimal;
	}

	public void salvar() {
		AnimalDAO animaldao = new AnimalDAOimp();

		animaldao.save(this.animal);

		this.animal = new Animal();
	}

	public void removerPermanente(Animal animal) {

		AnimalDAO animaldao = new AnimalDAOimp();
		animaldao.delete(animal);

	}

	public void editar(Animal animal) {

		this.animal = animal;

	}

}
