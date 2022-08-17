package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apiDeFilmes.enums.Plano;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo_plano")
	private Integer tipoPlano;
	private String email;
	private String senha;
	private String telefone;
	
	@OneToMany
	private Set<Pagamento> pagamentos = new HashSet<Pagamento>();

	@OneToMany
	private Set<PerfilEControleParental> perfis = new HashSet<PerfilEControleParental>();
	
	public Conta() {		
	}	

	public Conta(Plano tipoPlano, String email, String senha, String telefone, Set<Pagamento> pagamentos) {
		this.tipoPlano = tipoPlano.getCod();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.pagamentos = pagamentos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plano getTipoPlano() {
		return Plano.toEnum(tipoPlano);
	}

	public void setTipoPlano(Plano tipoPlano) {
		this.tipoPlano = tipoPlano.getCod();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Set<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Set<PerfilEControleParental> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<PerfilEControleParental> perfis) {
		this.perfis = perfis;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}	
}
