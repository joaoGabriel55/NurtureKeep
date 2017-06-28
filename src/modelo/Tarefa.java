package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Tarefa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6142036381277478394L;

	@Id
	@GeneratedValue
	@Column(name = "id_tarefa")
	private int id;

	@Column(nullable = false, length = 200)
	@NotNull(message = "Campo descrição não preenchido.")
	private String descricao;

	@Column(nullable = false)
	@NotNull(message = "Campo data de realização não preenchido.")
	private Date dataHoraRealizacao;

	@Column(nullable = false)
	@NotNull(message = "Campo data limite não preenchido.")
	private Date dataLimite;

	@Column(nullable = true)
	private Date dataRemocao;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@NotNull(message = "Não foi selecionado nenhum usuario preenchido.")
	private Usuario user;

	public Tarefa(String descricao, Date dataHoraRealizacao, Date dataLimite, Date dataRemocao, Usuario user) {
		super();
		this.descricao = descricao;
		this.dataHoraRealizacao = dataHoraRealizacao;
		this.dataLimite = dataLimite;
		this.dataRemocao = dataRemocao;
		this.user = user;
	}

	public Tarefa() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHoraRealizacao() {
		return dataHoraRealizacao;
	}

	public void setDataHoraRealizacao(Date dataHoraRealizacao) {
		this.dataHoraRealizacao = dataHoraRealizacao;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraRealizacao == null) ? 0 : dataHoraRealizacao.hashCode());
		result = prime * result + ((dataLimite == null) ? 0 : dataLimite.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (dataHoraRealizacao == null) {
			if (other.dataHoraRealizacao != null)
				return false;
		} else if (!dataHoraRealizacao.equals(other.dataHoraRealizacao))
			return false;
		if (dataLimite == null) {
			if (other.dataLimite != null)
				return false;
		} else if (!dataLimite.equals(other.dataLimite))
			return false;
		if (dataRemocao == null) {
			if (other.dataRemocao != null)
				return false;
		} else if (!dataRemocao.equals(other.dataRemocao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
