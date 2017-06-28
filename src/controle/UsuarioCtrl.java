package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;

import dao.UsuarioDAO;
import daoImplementation.UsuarioDAOimp;
import modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioCtrl {

	private Usuario usuario = new Usuario();
	private List<Usuario> listausers;
	private String confirmarSenha;
	private String destinoSalvar;

	public UsuarioCtrl() {
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
	}

	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/cadastrarUsuario";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListausers() {

		UsuarioDAO usuariodao = new UsuarioDAOimp();
		this.listausers = usuariodao.listAll();

		return listausers;
	}

	public void setListausers(List<Usuario> listausers) {
		this.listausers = listausers;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		UsuarioDAO usuariodao = new UsuarioDAOimp();

		usuariodao.save(this.usuario);

		this.usuario = new Usuario();

		return this.destinoSalvar;
	}

	// public void remover(Usuario usuario) {
	//
	// UsuarioDAO usuariodao = new UsuarioDAOimp();
	// usuario.setDataRemocao(Calendar.getInstance().getTime());
	// usuariodao.save(usuario);
	// }

	public void removerPermanente(Usuario usuario) {

		UsuarioDAO usuariodao = new UsuarioDAOimp();
		usuariodao.delete(usuario);

	}

	public String editar() {
		this.confirmarSenha = "";
		usuario.setSenha("");
		return "/publico/cadastrarUsuario";
	}

}
