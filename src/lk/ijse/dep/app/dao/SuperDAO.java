package lk.ijse.dep.app.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;

public interface SuperDAO {

    void setEntityManager(EntityManager em);

}
