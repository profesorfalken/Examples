package org.profesorfalken.examples.bbdd.dao;

import junit.framework.TestCase;

import org.profesorfalken.examples.bbdd.dao.model.User;

public class TestUserDAO extends TestCase {

	private UserDAO usuarioDAO = null;

	private long testId = 1;
	private String testName = "TestName";
	private String testNick = "TestNick";
	private String testPassword = "TestPassword";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testH2Impl() throws Exception {
		this.usuarioDAO = DaoFactory.getUsuarioDAO(DaoFactory.H2);

		performTest();
	}

	public void testJavaDBImpl() throws Exception {
		this.usuarioDAO = DaoFactory.getUsuarioDAO(DaoFactory.JAVADB);

		performTest();
	}

	private void performTest() throws Exception {
		this.usuarioDAO.init();

		this.usuarioDAO.insert(testId, testName, testNick, testPassword);

		User usuario = this.usuarioDAO.getUsuarioById(1);

		assertEquals(Long.valueOf(testId), usuario.getId());
		assertEquals(testName, usuario.getName());
		assertEquals(testNick, usuario.getNick());
		assertEquals(testPassword, usuario.getPassword());

		this.usuarioDAO.close();
	}
}
