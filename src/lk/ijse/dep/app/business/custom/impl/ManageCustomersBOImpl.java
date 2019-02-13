package lk.ijse.dep.app.business.custom.impl;

import lk.ijse.dep.app.business.Converter;
import lk.ijse.dep.app.business.custom.ManageCustomersBO;
import lk.ijse.dep.app.dao.DAOFactory;
import lk.ijse.dep.app.dao.custom.CustomerDAO;
import lk.ijse.dep.app.dto.CustomerDTO;
import lk.ijse.dep.app.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ManageCustomersBOImpl implements ManageCustomersBO {

    private CustomerDAO customerDAO;

    public ManageCustomersBOImpl() {
        customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    public List<CustomerDTO> getCustomers() throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            customerDAO.setEntityManager(em);
            em.getTransaction().begin();
            List<CustomerDTO> customerDTOS = customerDAO.findAll().map(Converter::<CustomerDTO>getDTOList).get();
            em.getTransaction().commit();
            return customerDTOS;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }

    }

    public void createCustomer(CustomerDTO dto) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            customerDAO.setEntityManager(em);
            em.getTransaction().begin();
            customerDAO.save(Converter.getEntity(dto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void updateCustomer(CustomerDTO dto) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            customerDAO.setEntityManager(em);
            em.getTransaction().begin();
            customerDAO.update(Converter.getEntity(dto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void deleteCustomer(String customerID) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            customerDAO.setEntityManager(em);
            em.getTransaction().begin();
            customerDAO.delete(customerID);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public CustomerDTO findCustomer(String id) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            customerDAO.setEntityManager(em);
            em.getTransaction().begin();
            CustomerDTO customerDTO = customerDAO.find(id).map(Converter::<CustomerDTO>getDTO).orElse(null);
            em.getTransaction().commit();
            return customerDTO;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

}
