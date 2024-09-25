package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@EnableJpaRepositories
@ComponentScan
@SpringBootApplication
public class ServicioReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioReservasApplication.class, args);
	}

//	@Bean
//	public RestClient getRestClient() {
//		return RestClient.create();
//	}
	
	@Bean
	@LoadBalanced
	public RestClient.Builder getBuilder(){
		return RestClient.builder();
	}
	@Bean
	public RestClient getRestClient(RestClient.Builder builder) {
		return builder.build();
	}
}
