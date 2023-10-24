package repository;

import dataAccess.LoginDao;

/**
 *
 * @author ASUS
 */
public class LoginRepository implements ILogin {

    @Override
    public void login(String type) {
        LoginDao.Instance().login(type);
    }
}
