package controller;

import repository.LoginRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class LoginController extends Menu{
    public static String[] mc = {"Vietnamese", "English", "Exit"};
    LoginRepository lr;
    
    public LoginController(){
        super("Login Program", mc);
        lr = new LoginRepository();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:{
                lr.login("Vi");
                break;
            }
            case 2:{
                lr.login("En");
                break;
            }
            case 3:{
                System.out.println("Closed..");
                System.exit(0);
            }
            default:{
                System.out.println("Choose again.");
            }
        }
    }
}
