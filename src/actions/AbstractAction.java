package actions;

import service.AbstractService;

public abstract class AbstractAction {
    private AbstractService service;

    public abstract AbstractService getService();

    public abstract void setService(AbstractService service);
}
