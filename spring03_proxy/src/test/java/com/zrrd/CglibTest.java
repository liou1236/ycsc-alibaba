package com.zrrd;

import com.zrrd.factory.ProductFactory;
import com.zrrd.pojo.Product;
import com.zrrd.service.Sale;
import com.zrrd.service.impl.SaleImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class CglibTest {
    @Test
    public void test(){
        Sale sale = new SaleImpl();
        // 创建增强对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(sale.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                ProductFactory productFactory = new ProductFactory();
                Product make = productFactory.make();
                double money = make.getPrice();
                System.out.println("money = " + money);

                double price = (double) objects[0];
                System.out.println("price = " + price);

//                System.out.println(args);
                if (money > price) {
                    System.out.println("not");
                    return null;
                } else {
                    System.out.println("yes,赚了" + (-money+price) + "钱");
                    return make;
                }
            }
        });

        Sale o =(Sale) enhancer.create();
        o.saleProduct(1200);
    }
}
