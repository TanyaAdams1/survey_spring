package actions;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import service.DeleteService;

public class DeleteAction extends DefaultActionSupport {
    private DeleteService deleteService;
    private String deleteList;

    public String getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(String deleteList) {
        this.deleteList = deleteList;
    }

    public DeleteService getDeleteService() {
        return deleteService;
    }

    public void setDeleteService(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @Override
    public String execute() throws Exception {
        try {
            System.out.println(deleteList);
            for (String id : getDeleteList().split(",")) {
                final String idResult = id.replaceAll("\\D+", "");
                System.out.println("deleting:" + idResult);
                deleteService.deletePerson(idResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
}