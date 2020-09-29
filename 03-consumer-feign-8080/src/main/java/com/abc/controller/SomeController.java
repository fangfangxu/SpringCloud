package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class SomeController {

//    @Autowired
//    private RestTemplate restTemplate;
    //直连提供者
//    private static final String SERVICE_PROVIDER = "http://localhost:8081";
    //使用微服务名称来从eureka server查找提供者
//     private static final String SERVICE_PROVIDER = "http://abcmsc-provider-depart";

    @Resource
    private DepartService service;

    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart) {
//        String url = SERVICE_PROVIDER + "/provider/depart/save";
        return service.saveDepart(depart);
    }


    @DeleteMapping("/del/{id}")
    public boolean deleteHandler(@PathVariable("id") int id) {
//        String url = SERVICE_PROVIDER + "/provider/depart/del/"+id;
//        restTemplate.delete(url);
        return service.removeDepartById(id);
    }


    @PutMapping("/update")
    public boolean updateHandler(@RequestBody Depart depart) {
//        String url = SERVICE_PROVIDER + "/provider/depart/update";
//        restTemplate.put(url, depart);
        return service.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getByIdHandler(@PathVariable("id") int id) {
//        String url = SERVICE_PROVIDER + "/provider/depart/get/"+id;
//        return restTemplate.getForObject(url, Depart.class);
        Depart departById = service.getDepartById(id);
        System.out.println(departById);
        return departById;
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
//        String url = SERVICE_PROVIDER + "/provider/depart/list";
//        return restTemplate.getForObject(url, List.class);
        return service.listAllDeparts();
    }

}
