package daoImplementation;

import dao.EnderecoDAO;
import modelo.Endereco;

public class EnderecoDAOimp extends GenericDAOimp<Endereco, Integer> implements EnderecoDAO {

	public EnderecoDAOimp() {
		super(Endereco.class);
	}
}
