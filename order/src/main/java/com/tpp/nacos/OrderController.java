package com.tpp.nacos;

import com.tpp.common.bean.ProductInfo;
import com.tpp.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/3/31 14:44
 */
@RestController
@RequestMapping("order")
@RefreshScope
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    @Value("${isNewBusi}")
    private Boolean isNewBusi;


    /**
     * 获取nacos注册服务列表
     *
     * @return
     */
    @GetMapping("/getServices")
    public List<ServiceInstance> getInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("order-center");
        return instances;
    }


    /**
     * ribbon，客户端集群
     *
     * @return
     */
    @GetMapping("/getStock")
    public ProductInfo getStock() {
        ResponseEntity<ProductInfo> responseEntity = restTemplate.getForEntity("http://product-center/product/detail/", ProductInfo.class);
        return responseEntity.getBody();
    }


    /**
     * feign使用test1
     *
     * @return
     */
    @GetMapping("/get_product")
    public ProductInfo getProduct(String id) {
        return productService.getProductInfo(id);
    }


    @GetMapping("/get_products")
    public ProductInfo getProducts(int id) {
        return productService.getProductInfos(id);
    }

    @GetMapping("/get_bus")
    public String getBus(){
        if (isNewBusi){
            return "执行旧逻辑";
        }
        return "执行新逻辑";
    }
}
