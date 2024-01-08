package br.com.neki.dto;

public class UsuarioLoginResponseDTO {
	private Integer Id;
	private String nomeUsuario;
	private Boolean autenticado;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Boolean getAutenticado() {
		return autenticado;
	}
	public void setAutenticado(Boolean autenticado) {
		this.autenticado = autenticado;
	} 

		
}
