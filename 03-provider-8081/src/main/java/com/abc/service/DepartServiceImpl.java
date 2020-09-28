package com.abc.service;

import com.abc.bean.Depart;
import com.abc.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {
        //对于save()的参数，根据其id的不同，有以下三种情况：
        //depart的id为null：save()执行的是插入
        //depart的id不为null，且DB中该id存在：save()执行的是修改
        //depart的id不为null，但DB中该id不存在：save()执行的是插入，但其插入的id值并不是这里指定的id
        Depart obj = repository.save(depart);
        return obj != null ? true : false;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if (repository.existsById(id)) {
            //在DB中指定的id若不存在，该方法会抛出异常
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        return obj != null ? true : false;
    }

    @Override
    public Depart getDepartById(int id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (repository.existsById(id)) {
            //在DB中指定的id若不存在，该方法会抛出异常
            return repository.getOne(id);
        }
        return new Depart();
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
