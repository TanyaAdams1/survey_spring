package actions;

import model.Person;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import service.ViewService;

import java.util.List;

public class ViewAction extends DefaultActionSupport {
    private ViewService viewService;
    private Person[] people;

    public ViewService getViewService() {
        return viewService;
    }

    public void setViewService(ViewService viewService) {
        this.viewService = viewService;
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    @Override
    public String execute() throws Exception {
        try {
            List<Person> personList = viewService.viewAll();
            people = personList.toArray(new Person[personList.size()]);
            return super.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
