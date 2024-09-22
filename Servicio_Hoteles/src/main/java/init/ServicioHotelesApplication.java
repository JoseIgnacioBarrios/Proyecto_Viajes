package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClient;
@EnableJpaRepositories
@ComponentScan
@SpringBootApplication
public class ServicioHotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioHotelesApplication.class, args);
	}


}
