package madx;

import madx.entity.Result;
import madx.service.CountJavaService;
import org.springframework.beans.factory.annotation.Autowired;
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

	
	@Autowired
	private CountJavaService countJavaService;
	
	@Override
	public void run(String... strings) throws Exception {
		Result result = countJavaService.count(1);
		System.out.println("result -- > "+result);
	}
}
