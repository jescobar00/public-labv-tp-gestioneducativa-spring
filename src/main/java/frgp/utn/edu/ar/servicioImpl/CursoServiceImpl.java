package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.ICursoDAO;
import frgp.utn.edu.ar.dominio.Curso;
import frgp.utn.edu.ar.dominio.TipoPeriodo;
import frgp.utn.edu.ar.servicio.ICursoService;

public class CursoServiceImpl implements ICursoService {
	private ICursoDAO dataAccess = null;

	public void setDataAccess(ICursoDAO dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public ArrayList<Curso> getAll() throws Exception {
		return dataAccess.getAll();
	}

	@Override
	public Curso get(int id) throws Exception {
		return dataAccess.get(id);
	}

	@Override
	public int getMax() throws Exception {
		return dataAccess.getMax();
	}

	@Override
	public int insert(Curso obj) throws Exception {
		return dataAccess.insert(obj);
	}

	@Override
	public boolean update(Curso obj) throws Exception {
		return dataAccess.update(obj);
	}

	@Override
	public boolean delete(int id) throws Exception {
		return dataAccess.delete(id);
	}

	@Override
	public ArrayList<Curso> getAllByDNIProfe(String dniProfesor) throws Exception {
		return dataAccess.getAllByDNIProfe(dniProfesor);
	}

	@Override
	public ArrayList<TipoPeriodo> getAllDistinctTipoPeriodo() throws Exception {
		return dataAccess.getAllDistinctTipoPeriodo();
	}

	@Override
	public ArrayList<Integer> getAllDistinctAnio() throws Exception {
		return dataAccess.getAllDistinctAnio();
	}

	@Override
	public ArrayList<Curso> getAllByNombreCursoBuscado(String nombreCurso) throws Exception {
		return dataAccess.getAllByNombreCursoBuscado(nombreCurso);
	}

	@Override
	public ArrayList<Curso> getAllByFiltroPeriodoAnio(int idTipoPeriodo, int anio) throws Exception {
		return dataAccess.getAllByFiltroPeriodoAnio(idTipoPeriodo, anio);
	}

	@Override
	public int getCountByDNIProfe(String dniProfesor) throws Exception {
		return dataAccess.getCountByDNIProfe(dniProfesor);
	}

}
