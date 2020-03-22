package plannermain;

/*
Author: Colin D Shepard
Day Planner Project
 */

import java.io.IOException;

public class PlannerMain {

    public static void main(String[] args) throws IOException {
        UserInput userinput = new UserInput();
        FileManage file = new FileManage();

        System.out.println("Welcome to Colin's Planner: ");
        System.out.println(file.date);
        System.out.println();

        int choice = -1;

        while (choice != 0) {

            System.out.println("Choose an option below: ");
            System.out.println("0: Exit program");
            System.out.println("1: Create an appointment");
            System.out.println("2: Edit an appointment");
            System.out.println("3: Delete an appointment");
            System.out.println("4: Save a calendar");
            System.out.println("5: Load a calendar");
            System.out.println("6: Print out calendar");

            choice = userinput.getInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    file.fillHash();
                    file.writeFile();

                    break;
                case 2:
                    file.editAppointment();
                    file.writeFile();

                    break;
                case 3:
                    file.deleteFile();
                    file.writeFile();
                    break;
                case 4:
                    file.Serialization();

                    break;
                case 5:
                    file.Deserialization();
                    file.writeFile();
                    break;

                case 6:
                    file.printFile();

                    break;
                default:

            }

        }

    }

}
