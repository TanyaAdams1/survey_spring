package actions;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import service.SubmitService;

import java.util.Objects;

public class SubmitAction extends DefaultActionSupport {
    private SubmitService submitService;
    private String name;
    private int age;
    private int gender;
    private String email;

    public SubmitAction() {
    }

    public SubmitAction(SubmitService submitService, String name, int age, int gender, String email) {
        this.submitService = submitService;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SubmitService getSubmitService() {
        return submitService;
    }

    public void setSubmitService(SubmitService submitService) {
        this.submitService = submitService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("Execute()");
        try {
            final String res = getSubmitService().addPerson(
                    getName(),
                    getAge(),
                    getGender(),
                    getEmail()
            );
            if (Objects.equals(res, "success"))
                return SUCCESS;
            else
                return "failed";
        } catch (Exception e) {
            return ERROR;
        }
    }
}
