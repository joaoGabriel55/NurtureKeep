package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AlimentoDAO;

import daoImplementation.AlimentoDAOimp;
import modelo.Alimento;

@ManagedBean
@SessionScoped
public class AlimentoCtrl {

	private Alimento alimento;
	private List<Alimento> listaAlimento;

	public AlimentoCtrl() {
		this.alimento = new Alimento.Builder(alimento.getNome(), alimento.getFabricacao(), alimento.getValidade(),
				alimento.getFornecedor()).build();
		AlimentoDAO alimentodao = new AlimentoDAOimp();
		this.listaAlimento = alimentodao.listAll();
	}

	public void reset() {
		this.alimento = new Alimento.Builder(alimento.getNome(), alimento.getFabricacao(), alimento.getValidade(),
				alimento.getFornecedor()).build();
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public List<Alimento> getListaAlimento() {
		AlimentoDAO alimentodao = new AlimentoDAOimp();
		this.listaAlimento = alimentodao.listAll();

		return listaAlimento;
	}

	public void setListaAlimento(List<Alimento> listaAlimento) {
		this.listaAlimento = listaAlimento;
	}

	public void salvar() {
		AlimentoDAO alimentodao = new AlimentoDAOimp();

		alimentodao.save(this.alimento);

		reset();
	}

	public void removerPermanente(Alimento alimento) {

		AlimentoDAO alimentodao = new AlimentoDAOimp();
		alimentodao.delete(alimento);

	}

	public void editar(Alimento alimento) {

		this.alimento = alimento;

	}

}
