package br.com.jkavdev.cidade.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = entityManager.getTransaction();
		boolean criador = false;

		try {
			if (!transaction.isActive()) {
				// Realizando roolback no que estiver no contexto da jpa
				transaction.begin();
				transaction.rollback();

				// Agora inicia uma nova transação
				transaction.begin();
				criador = true;
			}
			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && criador) {
				transaction.rollback();
			}

			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && criador) {
				transaction.commit();
			}
		}
	}

}
