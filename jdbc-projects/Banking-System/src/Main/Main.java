package Main;

import controller.BankController;
import util.DBInitializer;

public class Main {
    public static void main(String[] args) throws Exception{
        DBInitializer.initialize();
        BankController controller=new BankController();
        controller.menu();
    }
}
