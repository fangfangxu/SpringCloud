package com.abc.service;

import com.abc.bean.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 服务降级类
 */
@Component //生命周期交给Spring容器来管理
public class DepartFallbackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {
            @Override
            public boolean saveDepart(Depart depart) {
                System.out.println("执行saveDepart()的服务降级");
                return false;
            }

            @Override
            public boolean removeDepartById(Integer id) {
                System.out.println("执行removeDepartById()的服务降级");
                return false;
            }

            @Override
            public boolean modifyDepart(Depart depart) {
                System.out.println("执行modifyDepart()的服务降级");
                return false;
            }

            @Override
            public Depart getDepartById(Integer id) {
                System.out.println("执行getDepartById()的服务降级");
                //定义降级方法，即响应给客户端的备选方案
                    Depart depart = new Depart();
                    depart.setId(id);
                    depart.setName("no this depart服务降级---class");
                    return depart;

            }

            @Override
            public List<Depart> listAllDeparts() {
                System.out.println("执行listAllDeparts()的服务降级");
                return null;
            }
        };
    }
}
