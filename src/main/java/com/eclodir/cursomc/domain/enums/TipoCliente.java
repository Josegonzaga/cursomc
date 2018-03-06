package com.eclodir.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA (1, "Pessoa Física"),
	PESSOAJURIDICA (2, "Pessoa Jurídica");
	
	private int codigo;
	private String descricao;
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	
	private TipoCliente(int codigo, String desc) {
		this.codigo = codigo;
		this.descricao = desc;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente tc: TipoCliente.values() ) {
			if (cod.equals(tc.getCodigo())) {
				return tc;
			}
			
		}
		
		
		throw new IllegalArgumentException("Tipo do cliente código "+ cod +", não encontrado.");
		
		
	}
	
}
