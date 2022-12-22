package br.com.areadigital.backendmogodb;

import br.com.areadigital.backendmogodb.models.Person;
import br.com.areadigital.backendmogodb.models.Role;
import br.com.areadigital.backendmogodb.restrepository.PersonRestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class BackendmogodbApplication{// implements ApplicationRunner {

	private final BCryptPasswordEncoder passwordEncoder;
	private final PersonRestRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(BackendmogodbApplication.class, args);
	}


	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming application arguments
	 * @throws Exception on error
	 */
	/*@Override
	public void run(ApplicationArguments args) throws Exception {
		Person p =new Person();
		p.setPassword(passwordEncoder.encode("123456"));
		p.setLastname("Kill");
		p.setFirstname("Alex");
		p.setEmail("alex@gmail.com");
		p.setRoles(Arrays.asList(new Role("ROLE_OPERATOR") ));
		repo.save(p);
        p =new Person();
        p.setPassword(passwordEncoder.encode("123456"));
        p.setLastname("Bronx");
        p.setFirstname("Maria");
        p.setEmail("maria@gmail.com");
		p.setRoles(Arrays.asList(new Role("ROLE_OPERATOR"),new Role("ROLE_ADMI")));
        repo.save(p);
		log.info("Person: {}",p);
	}*/
}
