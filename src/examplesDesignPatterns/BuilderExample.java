package examplesDesignPatterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Alimento;
import modelo.Fornecedor;

public class BuilderExample {

	@SuppressWarnings("deprecation")
	public static final void main(String[] args) {

		Date fabricacao = new Date();
		fabricacao.getTime();

		Date validade = new Date();
		validade.setDate(30);
		validade.setMonth(01);
		validade.setYear(2020);

		Fornecedor fornecedor = Fornecedor.getInstance();
		fornecedor.setNome("Lucas");
		fornecedor.setCnpj("12121212121");

		List<Fornecedor> list = new ArrayList<Fornecedor>();

		list.add(fornecedor);

		Alimento builder = new Alimento.Builder("Macarrão", fabricacao, validade, list).build();
		Alimento builder2 = new Alimento.Builder("Arroz", fabricacao, validade, list).comCarboidratos(50.0).build();
		Alimento builder3 = new Alimento.Builder("Feijão", fabricacao, validade, list).comCarboidratos(100.0)
				.comGordurasTotais(44.0).build();

		System.out.println(builder.toString());
		System.out.println(builder2.toString());
		System.out.println(builder3.toString());

	}

}
