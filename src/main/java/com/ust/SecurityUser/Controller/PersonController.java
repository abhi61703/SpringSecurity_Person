package com.ust.SecurityUser.Controller;


import com.ust.SecurityUser.Common.PersonConstant;
import com.ust.SecurityUser.Model.Person;
import com.ust.SecurityUser.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerPerson(@RequestBody Person person){
        //person.setRole(PersonConstant.DEFAULT_ROLE);
        String encodePassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodePassword);
        personRepository.save(person);
        return "Hi" + person.getUsername() + ", your registration to the website is successful";
    }

    @GetMapping("/getallpersons")
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

}
