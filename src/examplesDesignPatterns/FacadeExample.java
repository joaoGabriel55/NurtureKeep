package examplesDesignPatterns;

import java.util.List;

import modelo.Fornecedor;
import modelo.Usuario;

public class FacadeExample {

	public void delete(List<Usuario> lista1, List<Fornecedor> lista2, Usuario usuario, Fornecedor fornecedor, Integer entrada) {

		if (entrada == 1)
			lista1.remove(usuario);
		else if (entrada == 2)
			lista2.remove(fornecedor);
		else if (entrada == 3) {
			lista1.remove(usuario);
			lista2.remove(fornecedor);
		}else
			System.out.println("SELECT A RIGHT OPTION");
			
		if (lista1.isEmpty() && lista2.isEmpty())
			System.out.println("REMOVED ALL DATA!");
		else if (lista2.isEmpty())
			System.out.println("REMOVED PROVIDER!");
		else if(lista1.isEmpty())
			System.out.println("REMOVED USER");
		else 
			System.out.println("NOT REMOVED!");
			
	}

}
