package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.TipoExamen;

public interface ITipoExamenDAO {

	public ArrayList<TipoExamen> getAll() throws Exception;

	public TipoExamen get(int id) throws Exception;

	public int getMax() throws Exception;

	public int insert(TipoExamen obj) throws Exception;

	public boolean update(TipoExamen obj) throws Exception;

	public boolean delete(int id) throws Exception;
}
