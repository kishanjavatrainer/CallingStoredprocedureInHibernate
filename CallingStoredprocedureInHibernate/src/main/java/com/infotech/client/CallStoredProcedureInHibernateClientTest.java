package com.infotech.client;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class CallStoredProcedureInHibernateClientTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("sp_count_phones");
			procedureQuery.registerStoredProcedureParameter( "personId", Long.class, ParameterMode.IN);
			procedureQuery.registerStoredProcedureParameter( "phoneCount", Long.class, ParameterMode.OUT);

			procedureQuery.setParameter("personId", 2L);

			procedureQuery.execute();
			Long phoneCount = (Long) procedureQuery.getOutputParameterValue("phoneCount");
			
			System.out.println("Phone Count:"+phoneCount);
		}
	}
}