package daoImplementation;

import dao.FornecedorDAO;
import modelo.Fornecedor;

public class FornecedorDAOimp extends GenericDAOimp<Fornecedor, Integer> implements FornecedorDAO {

	public FornecedorDAOimp() {
		super(Fornecedor.class);
	}

	public void save(Fornecedor fornecedor) {
		Integer codigo = fornecedor.getIdPessoa();
		System.out.println("Fornecedor é: " + codigo);

		if (codigo == null || codigo == 0) {
			fornecedor.setRole("ROLE_FORNECEDOR");
			System.out.println("Salvar usuário");
			super.save(fornecedor);
		} else {
			System.out.println("Atualizar usuário");
			System.out.println(fornecedor.getRole());
			super.update(fornecedor);
		}
	}
}
