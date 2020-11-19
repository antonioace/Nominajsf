package model;

import entities.Empleado;
import util.Conexion;
import util.GenericDao;
public class EmpleadoDAO extends Conexion<Empleado> implements GenericDao<Empleado>{
	
	public EmpleadoDAO() {
		// TODO Auto-generated constructor stub
		super(Empleado.class);
	}
	
	
public static void main(String[] args) {
	EmpleadoDAO e=new EmpleadoDAO();
	Empleado empleado=new Empleado();
	empleado=e.find("1");
	e.delete(empleado);

}
}
