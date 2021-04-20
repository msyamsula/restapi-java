package com.project.restapijava.Service;

import java.util.List;

import com.project.restapijava.Model.PersonModel;




public interface PersonService {
    public List<PersonModel> getAll();
    public PersonModel getById(Integer id);
    public String addPerson(PersonModel person);
    public String deleteById(Integer id);
    public String updateById(Integer id, PersonModel person);
}
