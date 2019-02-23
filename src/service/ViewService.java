package service;

import dao.interfaces.PersonDAO;
import model.Person;

import java.util.List;

public class ViewService {
    private PersonDAO personDAO;

    public ViewService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public ViewService() {
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public List<Person> viewAll() {
        return personDAO.findAll();
    }
}
