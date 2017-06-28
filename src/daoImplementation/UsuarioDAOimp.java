package daoImplementation;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOimp extends GenericDAOimp<Usuario, Integer> implements UsuarioDAO {

	 public UsuarioDAOimp() {
	        super(Usuario.class);
	 }
	 
	 public void save(Usuario usuario) {
		 Integer codigo = usuario.getIdPessoa();
		 System.out.println("Usuário é: " + codigo);
		 
		 if (codigo == null || codigo == 0){
			 usuario.setRole("ROLE_USUARIO");
			 System.out.println("Salvar usuário");
			 super.save(usuario);
		 }else{
			 System.out.println("Atualizar usuário");
			 System.out.println(usuario.getRole());
			 super.update(usuario);
		 }
	 }
}
