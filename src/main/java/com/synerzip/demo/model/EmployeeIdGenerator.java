package com.synerzip.demo.model;
import java.io.Serializable;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
public class EmployeeIdGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		String prefix = "EMP";
		Connection connection = session.connection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select count(eid) as Id from Employee");
			if (rs.next()) {
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();
				System.out.println("Generated Id: " + generatedId);
				return generatedId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
