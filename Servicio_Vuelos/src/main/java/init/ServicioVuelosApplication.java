package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan
@SpringBootApplication
public class ServicioVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVuelosApplication.class, args);
	}

}
