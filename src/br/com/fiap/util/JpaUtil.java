package br.com.fiap.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("faturamento");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}