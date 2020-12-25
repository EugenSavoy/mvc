package ru.eugen.spring.dao;

import org.springframework.stereotype.Component;
import ru.eugen.spring.model.People;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private static int Person_Count;
    List<People> people;

    {
        people = new ArrayList<>();
        people.add(new People(703, "Uasya", "Ivanov", 21, "1@mail.ru"));
        people.add(new People(++Person_Count, "Petya", "Ivanov", 43, "6@mail.ru"));
        people.add(new People(++Person_Count, "Kostya", "Ivanov", 41, "9@mail.ru"));
        people.add(new People(++Person_Count, "Masya", "Ivanov", 26, "11@mail.ru"));

    }

    public List<People> index(){
        return people;
    }

    public People show(int index) {
        return people.stream().filter(people -> people.getId()==index).findAny().orElse(null);
    }

    public void save(People person) {
        person.setId(++Person_Count);
        people.add(person);
    }

    public void update(int id, People person) {
        People uperson = show(703);
        uperson.setName(person.getName());
        uperson.setSurname(person.getSurname());
        uperson.setAge(person.getAge());
        uperson.setEmail(person.getEmail());
    }

    public void delete(int id) {
        People delPerson = show(703);
        people.remove(delPerson);
    }

}
