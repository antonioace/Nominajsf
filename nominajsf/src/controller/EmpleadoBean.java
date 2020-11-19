package controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entities.Empleado;
import model.EmpleadoDAO;

@ManagedBean(name = "empleadoBean")
@RequestScoped
public class EmpleadoBean {
	EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	
	
	public EmpleadoBean() {
		
		
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	}
	public List<Empleado> listaEmpleados() {
		

	
		System.out.println(empleadoDAO.list());
		return empleadoDAO.list();
		
	}
	
	public String eliminar(String id) {
	
	     Empleado empleado=empleadoDAO.find(id);
	     empleadoDAO.delete(empleado);
		System.out.println("Empleado eliminado..");
//		return "/faces/index.xhtml";
		return "index";
	}
	
	
	public String actualizar(Empleado empleado) {
		
		 empleadoDAO.update(empleado);
		 return "editForm";
	}
	
	public String editar(String id) {
		Empleado e= empleadoDAO.find(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("empleado", e);
		System.out.println("Empleado buscando empleado..");
		return "editForm";
	}
	
	
	
	
	public String agregar(Empleado empleado) {
		
		 empleadoDAO.insert(empleado);
		return "editForm";
	}
	
	public String ir() {
	Empleado e= new Empleado();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("empleado", e);
		return  "form";
	}
}
