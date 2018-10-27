package springBootP.webapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class bbsDeamon {

    @RequestMapping("/")
    public String index(){
        return "Hello,陈书函";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(bbsDeamon.class,args);
    }
}
