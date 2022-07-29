package com.apiDeFilmes.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.apiDeFilmes.enums.Plano;

public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Plano tipoPlano;
	private AssinaturaECobranca assECobr;
	
	private Set<Pagamento> pagamentos = new HashSet<Pagamento>();

	private Set<PerfilEControleParental> perfis = new HashSet<PerfilEControleParental>();
	
	public Conta() {		
	}

	public Conta(Integer id, Plano tipoPlano, AssinaturaECobranca assECobr) {
		this.id = id;
		this.tipoPlano = tipoPlano;
		this.assECobr = assECobr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plano getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(Plano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public AssinaturaECobranca getAssECobr() {
		return assECobr;
	}

	public void setAssECobr(AssinaturaECobranca assECobr) {
		this.assECobr = assECobr;
	}

	public Set<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public Set<PerfilEControleParental> getPerfis() {
		return perfis;
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
