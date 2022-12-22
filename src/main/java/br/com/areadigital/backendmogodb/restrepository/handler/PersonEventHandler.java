package br.com.areadigital.backendmogodb.restrepository.handler;

import br.com.areadigital.backendmogodb.models.Person;
import br.com.areadigital.backendmogodb.restrepository.PersonRestRepository;
import br.com.areadigital.backendmogodb.service.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonEventHandler extends AbstractRepositoryEventListener<Person> {

    private final BCryptPasswordEncoder passwordEncoder;
    private final PersonRestRepository userRepository;

//    @PersistenceContext
//    private EntityManager entityManager;

    /**
     * Override this method if you are interested in {@literal beforeCreate} events.
     *
     * @param entity The entity being created.
     */
    @Override
    protected void onBeforeCreate(Person entity) {
        try {
            if (entity.getPassword().length() > 0)
                entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        } catch (Exception e) {

        }
    }

    @Override
    protected void onBeforeSave(Person entity) {
//        entityManager.detach(entity);
        try {
            if (entity.getPassword().length() > 0)
                entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        } catch (Exception e) {

        } finally {
            Person s = userRepository.findById(entity.getId()).get();
            BeanUtils.copyProperties(entity, s, Util.getNullProperties(entity));
            BeanUtils.copyProperties(s, entity);
        }
    }
}
