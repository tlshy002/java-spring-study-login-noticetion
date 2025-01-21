package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import model.User_info;

@Repository
public class MyInformationDaoImpl implements MyInformationDao {
	private EntityManagerFactory emf;
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public User_info getUser(String id) {
		EntityManager em = this.emf.createEntityManager();
		return em.find(User_info.class, id); //기본키로 조회
	}

	@Override
	public void updateMyInformation(User_info user) {

	}

}
