package Mundo;

public class Cliente {
    
	/**
	 * Nombre del cliente.
	 */
	private String nombre;
	
	/**
	 * N�mero de identificaci�n del cliente.
	 */
	private String identificacion;
	
	/**
	 * Direcci�n de domicilio del cliente.
	 */
	private String direccion;
	
	/**
	 * Correo electr�nico del cliente.
	 */
	private String correo;

	/**
	 * Crear un cliente.
	 * @param nombre Nombre del cliente.
	 * @param identificacion N�mero de identificaci�n del cliente.
	 * @param direccion Direcci�n de domicilio del cliente.
	 * @param correo Correo electr�nico del cliente.
	 */
	public Cliente(String nombre, String identificacion, String direccion, String correo) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.correo = correo;
	}

	/**
	 * M�todo para obtener el nombre del cliente.
	 * @return Nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo para obtener el n�mero de identificaci�n del cliente.
	 * @return N�mero de identificaci�n del cliente.
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * M�todo para obtener la direcci�n del cliente.	
	 * @return Direcci�n del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * M�todo para obtener el correo electr�nico del cliente.
	 * @return Correo electr�nico del cliente.
	 */
	public String getCorreo() {
		return correo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
}
