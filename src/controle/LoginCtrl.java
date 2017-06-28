package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

@RequestScoped
@ManagedBean
public class LoginCtrl {
	@ManagedProperty(value = "#{usuarioCtrl}")
	private UsuarioCtrl usuario;
	private String email;
	private String senha;

	public String autentica() {
		FacesContext context = FacesContext.getCurrentInstance();

		for (Usuario u : usuario.getListausers()) {

			if (u.getEmail().equals(this.getEmail())) {
				if (u.getSenha().equals(this.getSenha())) {

					ExternalContext ec = context.getExternalContext();
					HttpSession s = (HttpSession) ec.getSession(true);
					s.setAttribute("usuario-logado", u);
					return "/usuario/indexUser?faces-redirect=true";
				}

			}
		}
		FacesMessage mensagem = new FacesMessage("Usuario/senha invalidos!");
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
		return null;
	}

	public String sair() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		HttpSession s = (HttpSession) ec.getSession(true);
		s.invalidate();
		return "saiu";
	}

	public UsuarioCtrl getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioCtrl usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
