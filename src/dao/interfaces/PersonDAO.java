package dao.interfaces;

import model.Person;

import java.util.List;

public interface PersonDAO {
    Person get(int id);

    int save(Person person);

    void update(Person person);

    void delete(Person person);

    List<Person> findAll();
}
