package Menus;

import java.util.Scanner;

import Models.School;
import Services.AccessValidator;

public class Menu {

    private AccessValidator accessValidator;
    private IMenuCommand menuCommand;

    public Menu() {
       this.accessValidator = new AccessValidator();
    }
    public void setMenu(IMenuCommand Command){
        this.menuCommand=Command;
    }
    public void executeMenuCommand() {
        menuCommand.execute();
    }

    public void startMenu(){
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        School school = new School("American School");
        System.out.println("=============================");
        System.out.println("Welcome to " + school.getName());
        System.out.println("=============================");
        System.out.println("Select your role please: ");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        //System.out.println("3. Principal"); //Could be added in the future and should have all access
        String option = scanner.nextLine();
        boolean access = false;

        while (!access) {
            System.out.println("Please enter your code");
            String code = scanner.nextLine();
            switch (option) {
                case "1":
                    if (this.accessValidator.verifyStudentAccess(code)) {
                        menu.setMenu(new StudentMenu(code));
                        menu.executeMenuCommand();
                        access=true;
                        break;
                    }
                    break;
                case "2":
                    if (this.accessValidator.verifyTeacherAccess(code)) {
                        menu.setMenu(new TeacherMenu(code));
                        menu.executeMenuCommand();
                        access=true;
                        break;
                    }
                    break;
            }
        }
        scanner.close();
    }

}
