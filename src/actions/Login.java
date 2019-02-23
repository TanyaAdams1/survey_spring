package actions;

import com.opensymphony.xwork2.ActionContext;
import dao.interfaces.AccountDAO;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.jetbrains.annotations.Contract;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;


public class Login extends DefaultActionSupport implements ServletRequestAware {
    private String redirect;
    private AccountDAO accountDAO;
    private HttpServletRequest request;

    public Login() {
        redirect = "http://162.105.146.180:8547/";
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public String execute() throws Exception {
        if (getServerletRequest() != null) {
            if (getServerletRequest().getCookies().length != 0) {
                for (Cookie cookie : getServerletRequest().getCookies()) {
                    if (cookie.getName().equalsIgnoreCase("token")) {
                        String result = accountDAO.verify(cookie.getValue());
                        if (Objects.equals(result, AccountDAO.TOKEN_ERROR) || Objects.equals(result, AccountDAO.SERVER_ERROR)) {
                            return result;
                        }
                        final String[] strings = result.split("\\n");
                        ActionContext context = ActionContext.getContext();
                        Map<String, Object> session = context.getSession();
                        session.put("name", strings[0]);
                        session.put("type", strings[1]);
                        session.put("contact", strings[2]);
                        context.setSession(session);
                        return AccountDAO.SUCCESS;
                    }
                }
            }
        }
        return AccountDAO.TOKEN_ERROR;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Contract(pure = true)
    private HttpServletRequest getServerletRequest() {
        return request;
    }
}
