package com.project.restapijava.Service;

import java.util.List;

import javax.persistence.EntityManager;

import com.project.restapijava.Model.PersonModel;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    private Session session;

    @Autowired
    public PersonServiceImpl(EntityManager entityManager) {
        this.session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public List<PersonModel> getAll() {
        // Session session = entityManager.unwrap(Session.class);

        Query<PersonModel> query = this.session.createQuery("from PersonModel", PersonModel.class);

        List<PersonModel> people = query.getResultList();

        return people;
    }

    @Override
    @Transactional
    public PersonModel getById(Integer id) {
        // Session session = entityManager.unwrap(Session.class);

        PersonModel person = this.session.get(PersonModel.class, id);

        return person;
    }

    @Override
    @Transactional
    public String addPerson(PersonModel person) {
        // Session session = entityManager.unwrap(Session.class);
        this.session.save(person);
        return "saved";
    }

    @Override
    @Transactional
    public String deleteById(Integer id) {
        PersonModel person = this.session.get(PersonModel.class, id);
        System.out.println(person.getName());
        System.out.println(person.getAccountId());
        this.session.delete(person);
        return "clean";
    }

    @Override
    @Transactional
    public String updateById(Integer id, PersonModel newPerson) {
        PersonModel person = this.session.get(PersonModel.class, id);
        person.setAccountId(newPerson.getAccountId());
        person.setAddress(newPerson.getAddress());
        person.setName(newPerson.getName());
        person.setId(newPerson.getId());

        this.session.save(person);
        return "updated";
    }
    
}
