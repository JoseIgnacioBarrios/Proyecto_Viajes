package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@ComponentScan
//@SpringBootApplication
@EntityScan
@SpringBootApplication
public class ServicioClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClienteApplication.class, args);
	}

}
