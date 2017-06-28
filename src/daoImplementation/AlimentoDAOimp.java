package daoImplementation;

import dao.AlimentoDAO;
import modelo.Alimento;

public class AlimentoDAOimp extends GenericDAOimp<Alimento, Integer> implements AlimentoDAO {

	public AlimentoDAOimp() {
		super(Alimento.class);
	}
	
}
