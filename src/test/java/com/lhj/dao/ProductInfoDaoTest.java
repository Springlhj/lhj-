package com.lhj.dao;

import com.lhj.entity.ProductInfo;
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
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        //类目编号
        productInfo.setCategoryType(5);
        ProductInfo info = productInfoDao.save(productInfo);
        Assert.assertNotNull(info);
    }
    @Test
    public void findByProductStatus() {
        List<ProductInfo> byProductStatus = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,byProductStatus.size());
    }
}