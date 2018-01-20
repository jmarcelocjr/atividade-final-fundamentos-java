package br.com.fiap.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.fiap.util.JpaUtil;

public class GenericDao<T> implements Dao<T> {
	
	private final Class<T> classe;
	protected EntityManager entityManager;
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	private EntityManager getEntityManger() {
		return JpaUtil.getEntityManager();
	}
	
	@Override
	public void adicionar(T entidade) {
		entityManager = this.getEntityManger();
		entityManager.getTransaction().begin();
		entityManager.persist(entidade);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked") @Override
	public List<T> listar() {
		entityManager = this.getEntityManger();
		return entityManager.createQuery("From " + this.classe.getSimpleName() + " classe").getResultList();
	}
	
	@Override
	public void atualizar(T entidade) {
		entityManager = this.getEntityManger();
		entityManager.getTransaction().begin();
		entityManager.merge(entidade);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public void remover(T entidade) {
		entityManager = this.getEntityManger();
		entityManager.getTransaction().begin();
		entityManager.remove(entidade);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public T buscar(int id) {
		entityManager = this.getEntityManger();
		entityManager.getTransaction().begin();
		T entidade = entityManager.find(this.classe, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entidade;
	}
}
