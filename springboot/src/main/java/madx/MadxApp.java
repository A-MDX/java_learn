package madx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MadxApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MadxApp.class, args);
	}

	
	
	
	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Running init is success...");
	}
}
