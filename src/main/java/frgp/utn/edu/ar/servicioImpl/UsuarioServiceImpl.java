package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.IUsuarioDAO;
import frgp.utn.edu.ar.dominio.TipoUsuario;
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.servicio.IUsuarioService;

public class UsuarioServiceImpl implements IUsuarioService {
	private IUsuarioDAO<Usuario> dataAccess = null;

	public void setDataAccess(IUsuarioDAO<Usuario> dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public ArrayList<Usuario> getAll() throws Exception {
		return this.dataAccess.getAll();
	}

	@Override
	public Usuario get(int id) throws Exception {
		return this.dataAccess.get(id);
	}

	@Override
	public int getMax() throws Exception {
		return this.dataAccess.getMax();
	}

	@Override
	public int insert(Usuario obj) throws Exception {
		return this.dataAccess.insert(obj);
	}

	@Override
	public boolean update(Usuario obj) throws Exception {
		return this.dataAccess.update(obj);
	}

	@Override
	public boolean delete(int id) throws Exception {
		return this.dataAccess.delete(id);
	}

	public Usuario getUsuarioByLogin(String correoUsuario, String claveUsuario) throws Exception {
		return dataAccess.getUsuarioByLogin(correoUsuario, claveUsuario);
	}

	public void validarCamposUnicos(Usuario objUsuario) throws Exception {
		dataAccess.validarCamposUnicos(objUsuario);
	}

	@Override
	public Usuario getUsuarioByDNI(String dni) throws Exception {
		return dataAccess.getUsuarioByDNI(dni);
	}

	@Override
	public boolean saveOrUpdate(Usuario obj) throws Exception {
		return dataAccess.saveOrUpdate(obj);
	}

	@Override
	public ArrayList<Usuario> getAllByDNIBuscado(String dni) throws Exception {
		return dataAccess.getAllByDNIBuscado(dni);
	}

	@Override
	public ArrayList<TipoUsuario> getAllTipoUsuarioByUsuarios() throws Exception {
		return dataAccess.getAllTipoUsuarioByUsuarios();
	}
}
