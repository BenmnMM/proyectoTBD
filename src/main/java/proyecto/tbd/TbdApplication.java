package proyecto.tbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories("proyecto.tbd.repository")
@ComponentScan(basePackages = { "proyecto.tbd.models" })
@ComponentScan(basePackages = { "proyecto.tbd.controllers"})
@EntityScan("proyecto.tbd.*")
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
