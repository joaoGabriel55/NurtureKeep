package examplesDesignPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Fornecedor;
import modelo.Usuario;

public class RunnableFacade {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FacadeExample facadeExample = new FacadeExample();

		Usuario usuario = new Usuario();
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		
		
		//Singleton
		Fornecedor fornecedor = Fornecedor.getInstance();
		List<Fornecedor> listFornecedores = new ArrayList<Fornecedor>();

		usuario.setNome("Joao");
		usuario.setCpf("1151665161");
		usuario.setEmail("j.quaresma@hotmail.com");
		usuario.setSenha("123abc");
		listUsuarios.add(usuario);

		fornecedor.setNome("Nicolas");
		fornecedor.setCpf("1151665161");
		fornecedor.setCnpj("887744444");
		fornecedor.setEmail("nicolas78@hotmail.com");
		fornecedor.setSenha("123abc");
		listFornecedores.add(fornecedor);

		System.out.println(usuario.toString());
		System.out.println(fornecedor.toString());
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("FOR DELETE: 1-Usuario, 2-Fornecedor, 3- All");
		int op = entrada.nextInt();
		
		facadeExample.delete(listUsuarios, listFornecedores, usuario, fornecedor, op);
	}

}
