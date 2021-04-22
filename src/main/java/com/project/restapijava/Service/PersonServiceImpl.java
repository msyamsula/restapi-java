package com.project.restapijava.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.project.restapijava.Model.PersonModel;

// import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    // private Session session;
    private EntityManager theEntityManager;

    @Autowired
    public PersonServiceImpl(EntityManager entityManager) {
        // this.session = entityManager.unwrap(Session.class);
        this.theEntityManager = entityManager;
    }

    @Override
    @Transactional
    public List<PersonModel> getAll() {
        // Session session = entityManager.unwrap(Session.class);

        // choose one of method below for querying
        // 1. hibernate session (using hibernate)
        // Query<PersonModel> query = this.session.createQuery("from PersonModel", PersonModel.class);
        // 2. jpa (using java persistence api)
        TypedQuery<PersonModel> query = this.theEntityManager.createQuery("from PersonModel", PersonModel.class);


        List<PersonModel> people = query.getResultList();

        return people;
    }

    @Override
    @Transactional
    public PersonModel getById(Integer id) {
        // Session session = entityManager.unwrap(Session.class);

        // choose one of type below for querying
        // 1. hibernate session (using hibernate)
        // PersonModel person = this.session.get(PersonModel.class, id);
        // 2. jpa (using java persistence api)
        PersonModel person = this.theEntityManager.find(PersonModel.class, id);

        return person;
    }

    @Override
    @Transactional
    public String addPerson(PersonModel person) {
        
        // 1. using hibernate
        // this.session.save(person);

        // 2. using jpa
        this.theEntityManager.merge(person);
        return "saved";
    }

    @Override
    @Transactional
    public String deleteById(Integer id) {
        // 1. using jpa
        Query query = this.theEntityManager.createQuery("delete from PersonModel p where p.id=:personId");
        query.setParameter("personId", id);
        query.executeUpdate();

        // 2. using hibernate
        // PersonModel person = this.session.get(PersonModel.class, id);
        // this.session.delete(person);
        return "clean";
    }

    @Override
    @Transactional
    public String updateById(Integer id, PersonModel newPerson) {

        
        // 1. hibernate session (using hibernate)
        // this.session.saveOrUpdate(newPerson);

        // 2. jpa (using java persistence api)
        // merge behaviour is: if newPerson id == 0 then add else update
        this.theEntityManager.merge(newPerson);
        

        return "updated";
    }
    
}
