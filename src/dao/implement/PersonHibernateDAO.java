package dao.implement;

import dao.interfaces.PersonDAO;
import model.Person;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PersonHibernateDAO extends HibernateDaoSupport implements PersonDAO {
    private SessionFactory sessionFactory;


    @Override
    public Person get(int name) {
        return getHibernateTemplate().get(Person.class, name);
    }


    @Override
    public int save(Person person) {
        return (int) getHibernateTemplate().save(person);
    }

    @Override
    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

    @Override
    public void delete(Person person) {
        System.out.println("deleting:" + person);
        getHibernateTemplate().delete(person);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) getHibernateTemplate().find("from model.Person");
    }
}
