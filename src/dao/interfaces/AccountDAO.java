package dao.interfaces;

public interface AccountDAO {
    String SUCCESS = "success";
    String TOKEN_ERROR = "token error";
    String SERVER_ERROR = "server error";

    String verify(String token);
}
