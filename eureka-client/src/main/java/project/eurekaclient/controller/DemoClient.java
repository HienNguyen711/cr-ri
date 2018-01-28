package project.eurekaclient.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/cr-ri/{UserName}")
    public  String serviceInstancesByApplicationName(
            @PathVariable String UserName) {
        return "Hello "+UserName;
    }
}
