package org.profesorfalken.examples.bbdd.dao;

import org.profesorfalken.examples.bbdd.dao.impl.h2.UserDAOH2Impl;
import org.profesorfalken.examples.bbdd.dao.impl.javadb.UserDAOJavaDBImpl;

public class DaoFactory {
	public static final int JAVADB = 1;
	public static final int H2 = 2;

	public static UserDAO getUsuarioDAO(int whichFactory) {

		switch (whichFactory) {
		case JAVADB:
			return new UserDAOJavaDBImpl();
		case H2:
			return new UserDAOH2Impl();
		default:
			return null;
		}
	}
}
