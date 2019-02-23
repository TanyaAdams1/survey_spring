package service;

import dao.interfaces.PersonDAO;

public abstract class AbstractService {
    private PersonDAO personDAO;

    public abstract PersonDAO getPersonDAO();

    public abstract void setPersonDAO(PersonDAO personDAO);
}
