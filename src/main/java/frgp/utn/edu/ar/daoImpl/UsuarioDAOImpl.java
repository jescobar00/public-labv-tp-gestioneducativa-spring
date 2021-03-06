package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.IUsuarioDAO;
import frgp.utn.edu.ar.dominio.TipoUsuario;
import frgp.utn.edu.ar.dominio.Usuario;
import utils.constantes.ConstantesDAO;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioDAOImpl implements IUsuarioDAO<Usuario> {
	private HibernateTemplate hibernateTemplate = null;
	private final String fromTable = String.format("FROM %s", ConstantesDAO.Usuario);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ArrayList<Usuario> getAll() throws Exception {
		return (ArrayList<Usuario>) this.hibernateTemplate.loadAll(Usuario.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Usuario get(int id) throws Exception {
		return this.hibernateTemplate.get(Usuario.class, id);
	}

	@Override
	public int getMax() throws Exception {
		int maxID = 0;
		String queryHQL = String.format("SELECT MAX(user.idUsuario) %s user", fromTable);
		maxID = (int) this.hibernateTemplate.find(queryHQL).get(0);
		return maxID;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(Usuario obj) throws Exception {
		int idGenerado = (int) this.hibernateTemplate.save(obj);
		return idGenerado;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean update(Usuario obj) throws Exception {
		boolean estado = false;
		this.hibernateTemplate.update(obj);
		estado = true;
		return estado;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean delete(int idUsuario) throws Exception {
		boolean estado = false;
		Usuario obj = new Usuario();
		obj.setIdUsuario(idUsuario);
		this.hibernateTemplate.delete(obj);
		estado = true;
		return estado;
	}

	@Override
	public Usuario getUsuarioByDNI(String dni) throws Exception {
		Usuario objUsuario = null;
		String queryHQL = String.format("%s WHERE lower(dni) = lower('%s')", fromTable, dni);
		objUsuario = (Usuario) this.hibernateTemplate.find(queryHQL).get(0);
		if (objUsuario == null)
			throw new Exception("No se encontró al usuario con DNI: " + dni);
		return objUsuario;
	}

	@Override
	public Usuario getUsuarioByLogin(String correoUsuario, String claveUsuario) throws Exception {
		Usuario objUsuario = null;
		String queryHQL = String.format("%s WHERE lower(mail) = lower('%s')", fromTable, correoUsuario);
		try {
			objUsuario = (Usuario) this.hibernateTemplate.find(queryHQL).get(0);
		} catch (Exception e) {
			throw new Exception(String.format(
					"El correo electrónico ingresado no se encontró en los registros. Valor ingresado [%s]",
					correoUsuario));
		}
		if (!(claveUsuario.equals(objUsuario.getClave())))
			throw new Exception("La clave ingresada no es la correcta");
		return objUsuario;
	}

	/**
	 * Valida que no se repitan los campos:
	 * <ol>
	 * <li>IdUsuario</li>
	 * <li>DNI</li>
	 * <li>Mail</li>
	 * </ol>
	 * 
	 * @param objUsuario
	 * @throws Exception
	 */
	public void validarCamposUnicos(Usuario objUsuario) throws Exception {
		ArrayList<Usuario> listaUsuariosDB;
		listaUsuariosDB = this.getAll();

		for (Usuario dbObj : listaUsuariosDB) {
			if (objUsuario.getIdUsuario() != dbObj.getIdUsuario()) {
				// verificar si otros usuarios tienen ese dni o mail
				if (objUsuario.getDni().equalsIgnoreCase(dbObj.getDni()))
					throw new Exception("ERROR DB: El DNI ingresado ya se encuentra registrado en el sistema");

				if (objUsuario.getMail().equalsIgnoreCase(dbObj.getMail()))
					throw new Exception("ERROR DB: El mail ingresado ya se encuentra registrado en el sistema");
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveOrUpdate(Usuario obj) throws Exception {
		boolean estado = false;
		this.hibernateTemplate.saveOrUpdate(obj);
		estado = true;
		return estado;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ArrayList<Usuario> getAllByDNIBuscado(String dni) throws Exception {
		String likeParam = "'" + dni + "%')";
		String queryHQL = String.format("%s WHERE lower(dni) LIKE lower(%s", fromTable, likeParam);
		return (ArrayList<Usuario>) this.hibernateTemplate.find(queryHQL);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ArrayList<TipoUsuario> getAllTipoUsuarioByUsuarios() throws Exception {
		String queryHQL = String.format("SELECT DISTINCT objTipoUsuario %s", fromTable);
		return (ArrayList<TipoUsuario>) this.hibernateTemplate.find(queryHQL);
	}

}
