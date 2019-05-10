package com.lhj.service.impl;

import com.lhj.entity.ProductInfo;
import com.lhj.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl pro;
    @Test
    public void findOne() {
        ProductInfo productInfo = pro.findOne("123456");
        //判断条件  如果查出来的ProductId等于123456就算通过了
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        //查询所有在架的商品
        List<ProductInfo> upAll = pro.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        //PageRequest类继承了AbstractPageRequest，AbstractPageRequest实现了Pageable。Pageable只是一个接口，并不是一个类
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> all = pro.findAll(pageRequest);
//        System.out.println(all.getTotalElements());
        //只要它查出来 总数不等于0 说明通过了
        Assert.assertNotEquals(0,all.getTotalElements());
    }

    @Test
    @Transactional
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾2");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的虾");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        //类目编号
        productInfo.setCategoryType(2);
        ProductInfo product = pro.save(productInfo);
        Assert.assertNotNull(product);
    }
}