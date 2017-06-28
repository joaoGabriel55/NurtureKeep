package daoImplementation;

import dao.TarefaDAO;
import modelo.Tarefa;

public class TarefaDAOimp extends GenericDAOimp<Tarefa, Integer> implements TarefaDAO {

	public TarefaDAOimp() {
		super(Tarefa.class);
	}

}
