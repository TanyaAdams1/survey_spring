package dao.implement;

import dao.interfaces.AccountDAO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;

public class AccountSQLDAO implements AccountDAO {
    private String baseURL;

    public AccountSQLDAO() {
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Override
    public String verify(String token) {
        try {
            Logger.getGlobal().info("Verifying token: " + token);
            URL url = new URL(getBaseURL() + "?token=" + token);
            final InputStream stream = url.openStream();
            final JsonReader reader = Json.createReader(stream);
            final JsonObject object = reader.readObject();
            Logger.getGlobal().info("Token verification response got");
//            System.out.println("Got");
            if (!(object.getInt("success") == 0))
                return TOKEN_ERROR;
//            System.out.println("Success");
            JsonObject result = object.getJsonObject("result");
//            System.out.println("Parsed result:"+result.toString());
            String res = result.getString("name") + "\n" + result.getString("type") + "\n";
            try {
                String contact = result.getString("contact");
                return res + contact;
            } catch (Exception e) {
                return res + "None";
            }
        } catch (MalformedURLException e) {
            Logger.getGlobal().severe("Error in verification: " + Arrays.toString(e.getStackTrace()));
            return SERVER_ERROR;
        } catch (IOException e) {
            return SERVER_ERROR;
        }
    }
}
