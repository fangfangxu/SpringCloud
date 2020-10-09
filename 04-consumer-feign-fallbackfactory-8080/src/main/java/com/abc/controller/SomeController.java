package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    //指定该方法要使用服务降级，即当前处理器方法的运行过程中若发生异常，
    //无法给客户端正常响应时，就会调用fallbackMethod指定的方法
    @HystrixCommand(fallbackMethod = "getHystrixHandler")
    @GetMapping("/get/{id}")
    public Depart getByIdHandler(@PathVariable("id") int id) {
        Depart departById = service.getDepartById(id);
        System.out.println(departById);
        return departById;
    }

    //定义降级方法，即响应给客户端的备选方案
    public Depart getHystrixHandler(@PathVariable("id") int id){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart服务降级---method");
        return depart;
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
//        String url = SERVICE_PROVIDER + "/provider/depart/list";
//        return restTemplate.getForObject(url, List.class);
        return service.listAllDeparts();
    }

}
