package lk.ijse.dep.app.business.custom.impl;

import lk.ijse.dep.app.business.Converter;
import lk.ijse.dep.app.business.custom.ManageItemsBO;
import lk.ijse.dep.app.dao.DAOFactory;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.dto.CustomerDTO;
import lk.ijse.dep.app.dto.ItemDTO;
import lk.ijse.dep.app.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ManageItemsBOImpl implements ManageItemsBO {
    private ItemDAO itemDAO;
    public ManageItemsBOImpl(){
        itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    }
    @Override
    public List<ItemDTO> getItems() throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            itemDAO.setEntityManager(em);
            em.getTransaction().begin();
            List<ItemDTO> itemDTOS = itemDAO.findAll().map(Converter::<ItemDTO>getDTOList).get();
            em.getTransaction().commit();
            return itemDTOS;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void createItem(ItemDTO dto) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            itemDAO.setEntityManager(em);
            em.getTransaction().begin();
            itemDAO.save(Converter.getEntity(dto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void updateItem(ItemDTO dto) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            itemDAO.setEntityManager(em);
            em.getTransaction().begin();
            itemDAO.update(Converter.getEntity(dto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void deleteItem(String code) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            itemDAO.setEntityManager(em);
            em.getTransaction().begin();
            itemDAO.delete(code);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public ItemDTO findItem(String itemCode) throws Exception {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            itemDAO.setEntityManager(em);
            em.getTransaction().begin();
            ItemDTO itemDTO = itemDAO.find(itemCode).map(Converter::<ItemDTO>getDTO).orElse(null);
            em.getTransaction().commit();
            return itemDTO;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }


}
