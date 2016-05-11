package sample.test;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GreeterEndpoint {

    private final GreeterClient greeterClient;

    @RequestMapping(method = RequestMethod.GET)
    public String greeter() {
        return "Hello " + greeterClient.getCustomerToGreet().getFirstName();
    }
}
