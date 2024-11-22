package sg.edu.nus.iss.vttp5a_day5l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_day5l.model.Person;
import sg.edu.nus.iss.vttp5a_day5l.repo.ListRepo;

@Service
public class PersonService {
    @Autowired
    ListRepo personRepo;

    List<Person> persons = new ArrayList<>();

    public void addPerson(String redisKey, Person person) {
        personRepo.rightPush(redisKey, person.toString());
    }

    public List<Person> findAll(String key) {

        List<Object> listData = personRepo.getList(key);
        List<Person> persons = new ArrayList<>();

        for(Object data: listData) {

            String [] rawData = data.toString().split(",");
            Person p = new Person(Integer.parseInt(rawData[0]), rawData[1], rawData[2]);
            persons.add(p);
        }

        return persons;
    }

    public Boolean delete(String redisKey, Person person) {
        return personRepo.deleteItem(null, person.toString());
    }
}