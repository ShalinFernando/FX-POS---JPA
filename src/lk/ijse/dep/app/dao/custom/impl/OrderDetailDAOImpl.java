package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudDAOImpl;
import lk.ijse.dep.app.dao.custom.OrderDetailDAO;
import lk.ijse.dep.app.entity.OrderDetail;
import lk.ijse.dep.app.entity.OrderDetailPK;

import java.util.List;


public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail,OrderDetailPK> implements OrderDetailDAO {


    @Override
    public List<OrderDetail> find(String orderId) throws Exception {
        List<OrderDetail> list1 = em.createQuery("SELECT o FROM OrderDetail o where o.order.id=?1", OrderDetail.class)
                .setParameter(1,orderId)
                .getResultList();

        for (OrderDetail orderDetail : list1) {
            System.out.println(orderDetail.getOrder()+"imal"+orderDetail.getQty());
        }
        return list1;
    }
}
