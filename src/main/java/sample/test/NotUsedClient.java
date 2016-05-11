package sample.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("sampleApp")
public interface NotUsedClient {

    @RequestMapping(method = RequestMethod.GET, value = "/im/not/used")
    String getNothing();
}