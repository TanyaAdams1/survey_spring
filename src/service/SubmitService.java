package service;

import dao.interfaces.PersonDAO;
import model.Person;
import org.springframework.transaction.annotation.Transactional;

public class SubmitService {
    private PersonDAO personDAO;

    public SubmitService() {
    }

    public SubmitService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Transactional
    public String addPerson(String name, int age, int gender, String email) {
        Person person = new Person(name, age, gender, email);
        try {
            final int result = personDAO.save(person);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
