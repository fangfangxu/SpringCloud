package com.abc.service;

import com.abc.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//指定当前为feign客户端，参数为提供者的微服务名称
@FeignClient("abcmsc-provider-depart")
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/save")
    boolean saveDepart(@RequestBody Depart depart);

    @DeleteMapping("/del/{id}")
    boolean removeDepartById(@PathVariable("id") Integer id);

    @PutMapping("/update")
    boolean modifyDepart(@RequestBody Depart depart);

    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable("id") Integer id);

    @GetMapping("/list")
    List<Depart> listAllDeparts();
}
