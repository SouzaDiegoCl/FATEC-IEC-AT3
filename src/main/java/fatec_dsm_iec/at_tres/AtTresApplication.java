package fatec_dsm_iec.at_tres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class AtTresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtTresApplication.class, args);
	}

}
