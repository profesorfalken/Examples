package org.profesorfalken.examples.bbdd.dao;

import java.sql.SQLException;

import org.profesorfalken.examples.bbdd.dao.model.User;

public interface UserDAO {
	public void init() throws SQLException;

	public void insert(long id, String name, String nick, String password)
			throws SQLException;

	public User getUsuarioById(long id) throws SQLException;

	public void close() throws SQLException;
}
