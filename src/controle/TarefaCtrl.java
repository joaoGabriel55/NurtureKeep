package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.swing.plaf.synth.SynthSeparatorUI;

import dao.TarefaDAO;
import dao.UsuarioDAO;
import daoImplementation.TarefaDAOimp;
import daoImplementation.UsuarioDAOimp;
import modelo.Tarefa;
import modelo.Usuario;
import util.MessageUtil;

@ManagedBean
@SessionScoped
public class TarefaCtrl {

	private Tarefa tarefa;
	private List<Tarefa> listaTarefa;
	private Usuario usuario;

	public TarefaCtrl() {
		this.tarefa = new Tarefa();
		TarefaDAO tarefadao = new TarefaDAOimp();
		this.listaTarefa = tarefadao.listAll();
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getListaTarefa() {
		TarefaDAO tarefadao = new TarefaDAOimp();
		this.listaTarefa = tarefadao.listAll();

		return listaTarefa;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	public void salvar() {
		TarefaDAO tarefadao = new TarefaDAOimp();
		UsuarioDAO usuariodao = new UsuarioDAOimp();

		tarefa.getUser().setListaTarefas((ArrayList<Tarefa>) listaTarefa);

		// usuariodao.save(this.usuario);
		tarefadao.save(this.tarefa);

		this.tarefa = new Tarefa();
	}

	public void removerPermanente(Tarefa tarefa) {

		TarefaDAO tarefadao = new TarefaDAOimp();
		UsuarioDAO usuariodao = new UsuarioDAOimp();

		tarefa.getUser().setListaTarefas((ArrayList<Tarefa>) listaTarefa);

		tarefadao.delete(tarefa);

	}

	public void editar(Tarefa tarefa) {

		this.tarefa = tarefa;

	}
	
//	 public void mostrarTRF(ActionEvent evento) {
//	        this.tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaexibir");
//	        MessageUtil.MensagemSucesso( tarefa.getDescricao());
//	        System.out.println("joel: " + tarefa.getDescricao());
//	 }

}
