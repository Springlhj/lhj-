package com.lhj.dao;

import com.lhj.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public void saveTest(){
//        ProductCategory category = productCategoryDao.findOne(1);
//        category.setCategoryType(5);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }

    /**
     * 利用构造器构造对象进行保存
     */
    @Test
    //在service中添加事物注解和在单元测试中添加事物注解是不一样的
    //以前在service中添加此注解,表示这个方法里面如果有抛出异常的话,那么它会回滚,就之前产生的数据它会帮你删除掉
    //在单元测试里面加这个事物注解就是完全的回滚了。所做的所有操作,做完后它就帮你回滚了
    @Transactional
    public void constructionTest(){
        ProductCategory productCategory = new ProductCategory("lhj",9);
        ProductCategory result = productCategoryDao.save(productCategory);
        //判断是否成功  看result是否为空就行了
        Assert.assertNotNull(result);
        //不期望的       期望的   (不期望null,实际result)
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeInList(){
        //用 asList 方法产生的 List 是固定大小的，这也就意味着任何改变其大小的操作都是不允许的
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> byCategoryTypeIn = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }


    @Test
    public void testSort(){
        float mark;
        float[] a = {0.1f,2f,0.3f,3f,0.4f};
        for(int i = 0;i < a.length; i++){
            for(int j = i;j < a.length;j++){
                if(a[i] > a[j]){
                    mark = a[i];
                    a[i] = a[j];
                    a[j] = mark;
                }
            }
        }
        System.out.println("排序后的数组元素:"+Arrays.toString(a));
    }

    @Test
    public void testAge(){
        // 定义一个出生时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date bithday = null;
        try {
            bithday = format.parse("1996-8-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int age = getAgeByBirth(bithday);
        System.out.println(age);
    }
    private static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);
            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;

        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }
}