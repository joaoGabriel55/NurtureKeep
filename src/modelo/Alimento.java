package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "alimento")
public class Alimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1211791400134213806L;

	@Id
	@GeneratedValue // (strategy = GenerationType.IDENTITY)
	@Column(name = "id_alimento")
	private int id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "fornecedor_Alimento", joinColumns = {
			@JoinColumn(name = "fornecedor_ID") }, inverseJoinColumns = { @JoinColumn(name = "alimento_ID") })
	private List<Fornecedor> fornecedor;

	@Column(name = "nome", length = 50, nullable = true)
	@NotNull(message = "Campo nome não preenchido.")
	private String nome;

	@Column(nullable = false)
	@NotNull(message = "Campo quantidade não preenchido.")
	private Integer quantidade;

	@Column(nullable = false)
	@NotNull(message = "Campo peso não preenchido.")
	private Double peso = new Double(0);

	@Column(nullable = false)
	@NotNull(message = "Campo preco não preenchido.")
	private Double preco = new Double(0);

	@Column(nullable = false)
	@NotNull(message = "Campo data de validade não preenchido.")
	private Date validade;

	@Column(nullable = false)
	@NotNull(message = "Campo data de fabricacao não preenchido.")
	private Date fabricacao;

	@Column(nullable = true)
	@NotNull(message = "Campo carboidratos não preenchido.")
	private Double carboidratos = new Double(0);

	@Column(nullable = true)
	@NotNull(message = "Campo proteinas não preenchido.")
	private Double proteinas = new Double(0);

	@Column(nullable = true)
	@NotNull(message = "Campo gordurasTotais não preenchido.")
	private Double gordurasTotais = new Double(0);

	@Column(nullable = true)
	@NotNull(message = "Campo fibraAlimentar não preenchido.")
	private Double fibraAlimentar = new Double(0);

	@Column(nullable = true)
	@NotNull(message = "Campo sodio não preenchido.")
	private Double sodio = new Double(0);

	@Column(nullable = true)
	private Double valorEnergetico;

	@Column(nullable = true)
	private Date dataRemocao;

	public Alimento(Builder builder) {
		super();
		this.fornecedor = builder.fornecedores;
		this.nome = builder.nome;
		this.quantidade = builder.quantidade;
		this.peso = builder.peso;
		this.preco = builder.preco;
		this.validade = builder.validade;
		this.fabricacao = builder.fabricacao;
		this.carboidratos = builder.carboidratos;
		this.proteinas = builder.proteinas;
		this.gordurasTotais = builder.gordurasTotais;
		this.fibraAlimentar = builder.fibraAlimentar;
		this.sodio = builder.sodio;
		this.valorEnergetico = builder.valorEnergetico;
		this.dataRemocao = builder.dataRemocao;
	}

	public static class Builder {
		private String nome;
		private Date validade;
		private List<Fornecedor> fornecedores;
		private Integer quantidade;
		private Double peso = new Double(0);
		private Double preco = new Double(0);
		private Date fabricacao;
		private Double carboidratos = new Double(0);
		private Double proteinas = new Double(0);
		private Double gordurasTotais = new Double(0);
		private Double fibraAlimentar = new Double(0);
		private Double sodio = new Double(0);
		private Double valorEnergetico;
		private Date dataRemocao;

		public Builder(String nome, Date fabricacao, Date validade, List<Fornecedor> fornecedores) {
			if (nome == null || fabricacao == null || validade == null || fornecedores == null)
				throw new IllegalArgumentException("Nome, fabricação, validadade ou fornecedor não podem ser vazio!");

			this.nome = nome;
			this.fabricacao = fabricacao;
			this.validade = validade;
			this.fornecedores = fornecedores;
		}

		public Builder comQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
			return this;
		}

		public Builder comPeso(Double peso) {
			this.peso = peso;
			return this;
		}

		public Builder comPreco(Double preco) {
			this.preco = preco;
			return this;
		}

		public Builder comCarboidratos(Double carboidratos) {
			this.carboidratos = carboidratos;
			return this;
		}

		public Builder comProteina(Double proteinas) {
			this.proteinas = proteinas;
			return this;
		}

		public Builder comGordurasTotais(Double gordurasTotais) {
			this.gordurasTotais = gordurasTotais;
			return this;
		}

		public Builder comFribaAlimentar(Double fibraAlimentar) {
			this.fibraAlimentar = fibraAlimentar;
			return this;
		}

		public Builder comSodio(Double sodio) {
			this.sodio = sodio;
			return this;
		}

		public Builder comValorEnergetico(Double valorEnergetico) {
			this.valorEnergetico = valorEnergetico;
			return this;
		}

		public Alimento build() {
			return new Alimento(this);
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Double getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(Double carboidratos) {
		this.carboidratos = carboidratos;
	}

	public Double getProteinas() {
		return proteinas;
	}

	public void setProteinas(Double proteinas) {
		this.proteinas = proteinas;
	}

	public Double getGordurasTotais() {
		return gordurasTotais;
	}

	public void setGordurasTotais(Double gordurasTotais) {
		this.gordurasTotais = gordurasTotais;
	}

	public Double getFibraAlimentar() {
		return fibraAlimentar;
	}

	public void setFibraAlimentar(Double fibraAlimentar) {
		this.fibraAlimentar = fibraAlimentar;
	}

	public Double getSodio() {
		return sodio;
	}

	public void setSodio(Double sodio) {
		this.sodio = sodio;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getValorEnergetico() {
		return valorEnergetico;
	}

	public void setValorEnergetico(Double valorEnergetico) {
		this.valorEnergetico = (this.carboidratos * 4) + (this.gordurasTotais * 9) + (this.proteinas * 4);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carboidratos == null) ? 0 : carboidratos.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + ((fabricacao == null) ? 0 : fabricacao.hashCode());
		result = prime * result + ((fibraAlimentar == null) ? 0 : fibraAlimentar.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((gordurasTotais == null) ? 0 : gordurasTotais.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((proteinas == null) ? 0 : proteinas.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((sodio == null) ? 0 : sodio.hashCode());
		result = prime * result + ((validade == null) ? 0 : validade.hashCode());
		result = prime * result + ((valorEnergetico == null) ? 0 : valorEnergetico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (carboidratos == null) {
			if (other.carboidratos != null)
				return false;
		} else if (!carboidratos.equals(other.carboidratos))
			return false;
		if (dataRemocao == null) {
			if (other.dataRemocao != null)
				return false;
		} else if (!dataRemocao.equals(other.dataRemocao))
			return false;
		if (fabricacao == null) {
			if (other.fabricacao != null)
				return false;
		} else if (!fabricacao.equals(other.fabricacao))
			return false;
		if (fibraAlimentar == null) {
			if (other.fibraAlimentar != null)
				return false;
		} else if (!fibraAlimentar.equals(other.fibraAlimentar))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (gordurasTotais == null) {
			if (other.gordurasTotais != null)
				return false;
		} else if (!gordurasTotais.equals(other.gordurasTotais))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (proteinas == null) {
			if (other.proteinas != null)
				return false;
		} else if (!proteinas.equals(other.proteinas))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (sodio == null) {
			if (other.sodio != null)
				return false;
		} else if (!sodio.equals(other.sodio))
			return false;
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
			return false;
		if (valorEnergetico == null) {
			if (other.valorEnergetico != null)
				return false;
		} else if (!valorEnergetico.equals(other.valorEnergetico))
			return false;
		return true;
	}

}