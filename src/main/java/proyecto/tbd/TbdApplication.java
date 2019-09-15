package proyecto.tbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class TbdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TbdApplication.class, args);


    }
    /*@RequestMapping("/hello")
    public String hola(){
        return "Hola aplicacion";


    }*/

}
