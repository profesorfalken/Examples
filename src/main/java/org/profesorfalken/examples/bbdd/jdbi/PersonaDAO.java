package org.profesorfalken.examples.bbdd.jdbi;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface PersonaDAO {
	@SqlUpdate("insert into persona (id, nombre, apellidos, edad) values (:id, :nombre, :apellidos, :edad)")
	void insert(@Bind("id") long id, @Bind("nombre") String nombre,
			@Bind("apellidos") String apellidos, @Bind("edad") Integer edad);

	@SqlQuery("select nombre from persona where id = :id")
	String getNombreById(@Bind("id") long id);

	void close();
}
