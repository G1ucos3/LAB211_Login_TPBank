package dataAccess;

import common.Captcha;
import common.Validate;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ASUS
 */
public class LoginDao {

    private static LoginDao instance = null;
    Validate validate = new Validate();
    Captcha captcha = new Captcha();
    Locale localeEN = new Locale("En");
    Locale localeVI = new Locale("Vi");
    ResourceBundle rb;

    public static LoginDao Instance() {
        if (instance == null) {
            synchronized (LoginDao.class) {
                if (instance == null) {
                    instance = new LoginDao();
                }
            }
        }
        return instance;
    }

    public void login(String type) {
        if (type.equals("En")) {
            rb = ResourceBundle.getBundle("En", localeEN);
        } else {
            rb = ResourceBundle.getBundle("Vi", localeVI);
        }
        validate.checkAccountNumber(rb.getString("Account_number"),
                rb.getString("Wrong_number"));
        validate.checkPassWord(rb.getString("Password"),
                rb.getString("Wrong_password"));
        StringBuilder checkCode = captcha.createCaptcha(6);
        System.out.print(rb.getString("Captcha"));
        System.out.println(": " + checkCode);
        validate.checkCaptcha(rb.getString("InputCaptcha"),
                rb.getString("Wrong_captcha"), checkCode);
        System.out.println(rb.getString("Success"));
    }
}
