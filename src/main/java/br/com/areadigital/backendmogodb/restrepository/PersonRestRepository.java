package br.com.areadigital.backendmogodb.restrepository;

import br.com.areadigital.backendmogodb.models.Person;
import br.com.areadigital.backendmogodb.restrepository.view.PersonView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonView.class)
public interface PersonRestRepository extends PagingAndSortingRepository<Person, String> {

    List<Person> findByFirstnameContainingIgnoreCase(String name);
    Person findByEmail(String username);

    @RestResource(exported = false)
    void deleteById(String aLong);
}
