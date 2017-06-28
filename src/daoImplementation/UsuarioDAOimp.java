package daoImplementation;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOimp extends GenericDAOimp<Usuario, Integer> implements UsuarioDAO {

	 public UsuarioDAOimp() {
	        super(Usuario.class);
	 }
	 
	 public void save(Usuario usuario) {
		 Integer codigo = usuario.getIdPessoa();
		 System.out.println("Usu�rio �: " + codigo);
		 
		 if (codigo == null || codigo == 0){
			 usuario.setRole("ROLE_USUARIO");
			 System.out.println("Salvar usu�rio");
			 super.save(usuario);
		 }else{
			 System.out.println("Atualizar usu�rio");
			 System.out.println(usuario.getRole());
			 super.update(usuario);
		 }
	 }
}
