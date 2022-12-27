package br.com.areadigital.backendmogodb;

import br.com.areadigital.backendmogodb.restrepository.PersonRestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class BackendmogodbApplication{

	private final BCryptPasswordEncoder passwordEncoder;
	private final PersonRestRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(BackendmogodbApplication.class, args);
	}



}
