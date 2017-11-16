package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.FornecedorDAO;
import daoImplementation.FornecedorDAOimp;
import modelo.Endereco;
import modelo.Fornecedor;

@ManagedBean
@SessionScoped
public class FornecedorCtrl {

	private Fornecedor fornecedor;
	private List<Fornecedor> listaFornecedor;
	private String confirmarSenha;
	private String destinoSalvar;

	public FornecedorCtrl() {
		this.destinoSalvar = "fornecedorsucesso";
		this.fornecedor = Fornecedor.getInstance();
		this.fornecedor.setEndereco(new Endereco());
		this.fornecedor.setAtivo(true);
	}

	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.fornecedor = Fornecedor.getInstance();
		this.fornecedor.setEndereco(new Endereco());
		this.fornecedor.setAtivo(true);
		return "/publico/cadastrarFornecedor";
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getListaFornecedor() {

		FornecedorDAO fornecedordao = new FornecedorDAOimp();
		this.listaFornecedor = fornecedordao.listAll();

		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
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

	
		if (!this.fornecedor.getSenha().equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		FornecedorDAO fornecedordao = new FornecedorDAOimp();

		fornecedor.getEndereco().setFornecedor(fornecedor);

		fornecedordao.save(this.fornecedor);

		novo();
		
		return "publico/login.xhtml?faces-redirect=true";

	}

	public void removerPermanente(Fornecedor fornecedor) {

		FornecedorDAO fornecedordao = new FornecedorDAOimp();
		fornecedordao.delete(fornecedor);

	}

	public String editar() {
		this.confirmarSenha = "";
		fornecedor.setSenha("");
		return "/publico/cadastrarFornecedor";
	}

}
