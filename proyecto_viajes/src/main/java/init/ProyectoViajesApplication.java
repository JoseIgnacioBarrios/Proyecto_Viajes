package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan
@SpringBootApplication
public class ProyectoViajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoViajesApplication.class, args);
	}

}
