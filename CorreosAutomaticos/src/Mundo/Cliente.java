package Mundo;

public class Cliente {
    
	/**
	 * Nombre del cliente.
	 */
	private String nombre;
	
	/**
	 * Número de identificación del cliente.
	 */
	private String identificacion;
	
	/**
	 * Dirección de domicilio del cliente.
	 */
	private String direccion;
	
	/**
	 * Correo electrónico del cliente.
	 */
	private String correo;

	/**
	 * Crear un cliente.
	 * @param nombre Nombre del cliente.
	 * @param identificacion Número de identificación del cliente.
	 * @param direccion Dirección de domicilio del cliente.
	 * @param correo Correo electrónico del cliente.
	 */
	public Cliente(String nombre, String identificacion, String direccion, String correo) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.correo = correo;
	}

	/**
	 * Método para obtener el nombre del cliente.
	 * @return Nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para obtener el número de identificación del cliente.
	 * @return Número de identificación del cliente.
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Método para obtener la dirección del cliente.	
	 * @return Dirección del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método para obtener el correo electrónico del cliente.
	 * @return Correo electrónico del cliente.
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
