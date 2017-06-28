package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169160019152757705L;

	@Id
	@GeneratedValue
	@Column(name = "id_animal")
	private int id;

	@Column(length = 15, nullable = false)
	private String apelido;

	@Column(nullable = false)
	private Date dataNascimento;

	@Column(nullable = true)
	private Date dataRemocao;

	@Column(nullable = false)
	private String raca;

	@Column(nullable = false)
	private Double peso;

	@Column(nullable = false)
	private Double altura;

	@Column(nullable = false)
	private ArrayList<Alimento> lista = new ArrayList<Alimento>();

	public Animal(String apelido, Date dataNascimento, Date dataRemocao, String raca, Double peso, Double altura,
			ArrayList<Alimento> lista) {
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.dataRemocao = dataRemocao;
		this.raca = raca;
		this.peso = peso;
		this.altura = altura;
		this.lista = lista;
	}

	public Animal() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public ArrayList<Alimento> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Alimento> lista) {
		this.lista = lista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + id;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((raca == null) ? 0 : raca.hashCode());
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
		Animal other = (Animal) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (dataRemocao == null) {
			if (other.dataRemocao != null)
				return false;
		} else if (!dataRemocao.equals(other.dataRemocao))
			return false;
		if (id != other.id)
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (raca == null) {
			if (other.raca != null)
				return false;
		} else if (!raca.equals(other.raca))
			return false;
		return true;
	}

}
