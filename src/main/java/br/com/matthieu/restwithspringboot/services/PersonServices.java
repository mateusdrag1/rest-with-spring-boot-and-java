package br.com.matthieu.restwithspringboot.services;

import br.com.matthieu.restwithspringboot.data.vo.v1.PersonVO;
import br.com.matthieu.restwithspringboot.exceptions.ResourceNotFoundException;
import br.com.matthieu.restwithspringboot.mapper.DozerConverter;
import br.com.matthieu.restwithspringboot.models.Person;
import br.com.matthieu.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("find all in person services");

        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }


    public PersonVO findById(Long id) {
        logger.info("find by id in person services");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("create in person services");

        var entity = DozerConverter.parseObject(person, Person.class);

        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(Long id, PersonVO person) {
        logger.info("update in person services");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("delete in person services");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
