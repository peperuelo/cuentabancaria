package model;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private int cedula;
	private int telefono;
	private String email;
	private int ciudad;
	private int pais;
	
	public Cliente(int idCliente, String nombre, String apellido, int cedula, int telefono, String email, int ciudad,
			int pais) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	

	public Cliente( String nombre, String apellido, int cedula, int telefono, String email, int ciudad,
			int pais) {
		this.idCliente = 0;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.ciudad = ciudad;
		this.pais = pais;
	}



	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula="
				+ cedula + ", telefono=" + telefono + ", email=" + email + ", ciudad=" + ciudad + ", pais=" + pais
				+ "]";
	}
	
	


}
