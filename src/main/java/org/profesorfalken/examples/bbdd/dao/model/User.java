package org.profesorfalken.examples.bbdd.dao.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -3433664542492925919L;

	private Long id;
	private String name;
	private String nick;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
