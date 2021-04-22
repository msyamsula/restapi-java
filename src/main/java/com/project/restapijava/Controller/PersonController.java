package com.project.restapijava.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.project.restapijava.Model.PersonModel;
import com.project.restapijava.ReqBody.PostPersonReqBody;
import com.project.restapijava.ReqBody.PutPersonReqBody;
import com.project.restapijava.Service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PersonController {

    @Autowired
    private PersonService service;
    
    @GetMapping(value="/person/all")
    public List<PersonModel> getAll() {
        List<PersonModel> people = service.getAll();
        return people;
    }

    @GetMapping("/person")
    public PersonModel getParamId(@RequestParam Integer id){
        PersonModel result = service.getById(id);

        return result;
    }

    @GetMapping(value="/person/{idString}")
    public PersonModel getByBodyId(@PathVariable String idString) {
        Integer id = Integer.parseInt(idString);
        // System.out.println(name);
        PersonModel result = service.getById(id);
        return result;
    }

    @PostMapping("/person")
    public String addPerson(@RequestBody PostPersonReqBody personReqBody) {
        PersonModel person = new PersonModel(personReqBody.name, personReqBody.accountId);
        person.setAddress(personReqBody.address);
        return service.addPerson(person);
    }

    @DeleteMapping("/person/{idStr}")
    public String cleanUp(@PathVariable String idStr){
        Integer id = Integer.parseInt(idStr);
        service.deleteById(id);
        return "database clean";
    }

    @PutMapping("/person/{idStr}")
    public String updateById(@RequestBody PutPersonReqBody personReq, @PathVariable String idStr){
        Integer id = Integer.parseInt(idStr);
        PersonModel person = new PersonModel();
        
        person.setAccountId(personReq.getAccountId());
        person.setId(id);
        person.setName(personReq.getName());
        person.setAddress(personReq.getAddress());

    
        service.updateById(id, person);    

        return "updated";
    }
    
    
    
}
