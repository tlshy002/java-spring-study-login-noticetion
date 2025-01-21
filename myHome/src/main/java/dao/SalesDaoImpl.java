package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

@Repository
public class SalesDaoImpl implements SalesDao {
	private EntityManagerFactory emf;
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Object[]> getSales(String id) {
		EntityManager em = this.emf.createEntityManager();
		List<Object[]> list =
			em.createQuery(
					"from Sale_tbl  as sales inner join sales.details"
					+ "where sales.user_id = :id order by sales.sale_id", Object[].class)
					.setParameter("id", id).getResultList();
		return list;
	}

}
