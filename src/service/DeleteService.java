package service;

import dao.interfaces.PersonDAO;
import org.springframework.transaction.annotation.Transactional;

public class DeleteService {
    private PersonDAO personDAO;

    public DeleteService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public DeleteService() {

    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public void deletePerson(String id) {
        personDAO.delete(
                personDAO.get(Integer.parseInt(id))
        );
    }
}
