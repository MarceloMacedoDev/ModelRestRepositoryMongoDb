package br.com.areadigital.backendmogodb.restrepository;

import br.com.areadigital.backendmogodb.models.Person;
import br.com.areadigital.backendmogodb.restrepository.view.PersonView;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * This interface represents a Spring Data REST Repository for the {@link Person} entity.
 * <p>
 * It extends the {@link PagingAndSortingRepository} interface and uses the {@link PersonView} projection as the default
 * <p>
 * projection for entity queries.
 */
@RepositoryRestResource(excerptProjection = PersonView.class)
public interface PersonRestRepository extends PagingAndSortingRepository<Person, String> {

    /**
     * Searches for all {@link Person} entities that contain a specific name (case insensitive) in their first name.
     *
     * @param name The name to search for
     * @return A list of {@link Person} entities that match the search criteria
     */
    List<Person> findByFirstnameContainingIgnoreCase(String name);

    /**
     * Finds a {@link Person} entity by its email address.
     *
     * @param username The email address to search for
     * @return The {@link Person} entity with the specified email address, or null if not found
     */
    Person findByEmail(String username);

    /**
     * Deletes a {@link Person} entity by its ID.
     *
     * @param aLong The ID of the {@link Person} entity to delete
     */
    @RestResource(exported = false)
    void deleteById(String aLong);
}


 
