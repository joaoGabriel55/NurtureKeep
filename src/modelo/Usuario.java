package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Usuario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9033765464582859175L;

	/**
	 * 
	 */

	@Column(nullable = true)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL})
	private ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();

	@Column(nullable = true)
	private Boolean admin = false;

	public Usuario(String nome, String email, String cpf, Date dataNascimento, Date dataRemocao, String telefone,
			String senha, Boolean ativo, String role, ArrayList<Tarefa> listaTarefas, Boolean admin) {
		super(nome, email, cpf, dataNascimento, dataRemocao, telefone, senha, ativo, role);
		this.listaTarefas = listaTarefas;
		this.admin = admin;
	}

	public Usuario() {
	}

	public ArrayList<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((listaTarefas == null) ? 0 : listaTarefas.hashCode());
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
		Usuario other = (Usuario) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (listaTarefas == null) {
			if (other.listaTarefas != null)
				return false;
		} else if (!listaTarefas.equals(other.listaTarefas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getCpf()=" + getCpf()
				+ ", getDataNascimento()=" + getDataNascimento() + ", getTelefone()=" + getTelefone() + ", getSenha()="
				+ getSenha() + ", getDataRemocao()=" + getDataRemocao() + ", getIdPessoa()=" + getIdPessoa()
				+ ", getAtivo()=" + getAtivo() + ", getRole()=" + getRole() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
