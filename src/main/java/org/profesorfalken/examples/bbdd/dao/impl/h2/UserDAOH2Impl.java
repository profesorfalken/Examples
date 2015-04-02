package org.profesorfalken.examples.bbdd.dao.impl.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.profesorfalken.examples.bbdd.dao.UserDAO;
import org.profesorfalken.examples.bbdd.dao.model.User;

public class UserDAOH2Impl implements UserDAO {
	Connection conn = null;

	public Connection createConnection() throws ClassNotFoundException,
			SQLException {
		if (conn == null) {
			Class.forName("org.h2.Driver");
			conn = DriverManager
					.getConnection("jdbc:h2:mem:DAOtest;create=true");
		}

		return conn;
	}

	public void init() throws SQLException {
		Connection conn = null;
		Statement stm = null;

		try {
			conn = createConnection();
			stm = conn.createStatement();
			stm.executeUpdate("create table user (id long primary key, "
					+ "name varchar, " + "nick varchar, " + "password varchar)");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null)
				stm.close();
		}

	}

	public void insert(long id, String name, String nick, String password)
			throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = createConnection();
			pstm = conn
					.prepareStatement("insert into user (id, name, nick, password) "
							+ "values (?, ?, ?, ?)");
			pstm.setLong(1, id);
			pstm.setString(2, name);
			pstm.setString(3, nick);
			pstm.setString(4, password);

			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstm != null)
				pstm.close();
		}
	}

	public User getUsuarioById(long id) throws SQLException {
		User usuario = new User();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = createConnection();
			pstm = conn.prepareStatement("select id, name, nick, password "
					+ "from user where id = ?");
			pstm.setLong(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				usuario.setId(rs.getLong(1));
				usuario.setName(rs.getString(2));
				usuario.setNick(rs.getString(3));
				usuario.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
		}

		return usuario;
	}

	public void close() throws SQLException {
		this.conn.close();
		this.conn = null;
	}

}
