package modelo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Fornecedor extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3258406747052720211L;

	/**
	 * 
	 */

	/**
	 * Singleton. Criar apenas uma instancia do objeto
	 * 
	 */
	private static Fornecedor instance = new Fornecedor();

	@Column(nullable = false, length = 50)
	private String empresa;

	@Column(nullable = false)
	private String cnpj;

	@OneToOne
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE })
	@PrimaryKeyJoinColumn(name = "id_fornecedor")
	private Endereco endereco;

	@ManyToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
	private List<Alimento> listaAlimento;

	public Fornecedor(String nome, String email, String cpf, Date dataNascimento, Date dataRemocao, String telefone,
			String senha, Boolean ativo, String role, int id, String empresa, String cnpj, Endereco endereco,
			List<Alimento> listaAlimento) {
		super(nome, email, cpf, dataNascimento, dataRemocao, telefone, senha, ativo, role);
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.listaAlimento = listaAlimento;
	}

	/**
	 * 
	 * Faz um construtor privado para que a classe não possa ser instanciada.
	 */
	private Fornecedor() {
	}

	public static Fornecedor getInstance() {
		return instance;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Alimento> getListaAlimento() {
		return listaAlimento;
	}

	public void setListaAlimento(List<Alimento> listaAlimento) {
		this.listaAlimento = listaAlimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((listaAlimento == null) ? 0 : listaAlimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (listaAlimento == null) {
			if (other.listaAlimento != null)
				return false;
		} else if (!listaAlimento.equals(other.listaAlimento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [empresa=" + empresa + ", cnpj=" + cnpj + ", endereco=" + endereco + ", listaAlimento="
				+ listaAlimento + ", getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getCpf()=" + getCpf()
				+ ", getDataNascimento()=" + getDataNascimento() + ", getTelefone()=" + getTelefone() + ", getSenha()="
				+ getSenha() + ", getDataRemocao()=" + getDataRemocao() + ", getIdPessoa()=" + getIdPessoa()
				+ ", getAtivo()=" + getAtivo() + ", getRole()=" + getRole() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

}
