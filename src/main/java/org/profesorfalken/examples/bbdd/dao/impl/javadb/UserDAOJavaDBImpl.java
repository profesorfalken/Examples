package org.profesorfalken.examples.bbdd.dao.impl.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.profesorfalken.examples.bbdd.dao.UserDAO;
import org.profesorfalken.examples.bbdd.dao.model.User;

public class UserDAOJavaDBImpl implements UserDAO {

	public static Connection createConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection conn = DriverManager
				.getConnection("jdbc:derby:memory:DAOtest;create=true");

		return conn;
	}

	public void init() throws SQLException {
		Connection conn = null;
		Statement stm = null;

		try {
			conn = createConnection();
			stm = conn.createStatement();
			stm.executeUpdate("create table users (id integer not null, "
					+ "name varchar(255), " + "nick varchar(255), "
					+ "password varchar(255), " + "primary key (id))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stm != null)
				stm.close();
			if (conn != null)
				conn.close();
		}

	}

	public void insert(long id, String name, String nick, String password)
			throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = createConnection();
			pstm = conn
					.prepareStatement("insert into users (id, name, nick, password) "
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
			if (conn != null)
				conn.close();
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
					+ "from users where id = ?");
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
			if (conn != null)
				conn.close();
		}

		return usuario;
	}

	public void close() throws SQLException {
		// Not implemented since it is closed for each operation
	}

}
