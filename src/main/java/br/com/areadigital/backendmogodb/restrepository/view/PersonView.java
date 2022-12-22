package br.com.areadigital.backendmogodb.restrepository.view;

import br.com.areadigital.backendmogodb.models.Person;
import br.com.areadigital.backendmogodb.models.add.Contato;
import br.com.areadigital.backendmogodb.models.add.Endereco;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "personView", types = {Person.class})
public interface PersonView {
//	@Value("#{target.firstname}")
	String getFirstname();
//	@Value("#{target.firstname}")
//	void setFirst_name(String firstname);
	String getLastname();
	String getEmail();
	Contato getContato();
	Endereco getEndereco();

}
