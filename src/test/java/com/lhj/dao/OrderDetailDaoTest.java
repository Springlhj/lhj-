package com.lhj.dao;

import com.lhj.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("111111123");
        orderDetail.setDetailId("134891321");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("12312321");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(3);
        OrderDetail save = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrOrderId() {
        List<OrderDetail> byOrOrderId = orderDetailDao.findByOrOrderId("111111");
        Assert.assertNotEquals(0,byOrOrderId.size());
    }
}