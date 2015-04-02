package org.profesorfalken.examples.bbdd.jdbi;

import junit.framework.TestCase;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public class TestPersonaDAO extends TestCase {
	private DBI dbi;

	@Override
	protected void setUp() throws Exception {
		this.dbi = new DBI("jdbc:h2:mem:jdbitest;create=true");

		Handle h = dbi.open();
		h.execute("create table persona (id long primary key, nombre varchar, apellidos varchar, edad int)");
		h.close();

		super.setUp();
	}

	public void testInsertAndGetPersona() throws ClassNotFoundException {
		PersonaDAO dao = dbi.open(PersonaDAO.class);

		dao.insert(1, "Mark", "Larssen", 40);
		dao.insert(2, "Otto", "Markinov", 50);

		String nombre = dao.getNombreById(1);

		assertEquals("Mark", nombre);

		dao.close();
	}
}