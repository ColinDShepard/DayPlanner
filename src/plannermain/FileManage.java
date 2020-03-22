package plannermain;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FileManage extends Appointment {

    UserInput userinput = new UserInput();

    public void writeFile() {

        try {

            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter out = new BufferedWriter(fw);

            int records = date.size();
            int count = 0;

            Iterator<Entry<String, ArrayList<String>>> it = date.entrySet().iterator();

            while (it.hasNext() && count < records) {

                Map.Entry<String, ArrayList<String>> pairs = it.next();

                out.write(pairs.getKey() + " " + pairs.getValue());
                out.newLine();

                count++;

            }

            out.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public void Serialization() {

        System.out.println("Name the file: ");
        String name = userinput.getString(1, 15) + ".ser";
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(date);

            out.close();
            file.close();
            System.out.println("Object has been serialized");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void Deserialization() {
        System.out.println("Name the file to read: ");
        String name = userinput.getString(1, 15) + ".ser";
        try {
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream input = new ObjectInputStream(file);

            date = (HashMap) input.readObject();

            input.close();
            file.close();

            System.out.println("Object has been deserialized");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println(date);

    }

    public void printFile() {
        File file = new File("C:\\Users\\Colin\\Documents\\NetBeansProjects\\PlannerMain\\data.txt");

        try {
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop version is not supported");

            }

            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.print(file);

            } else {
                System.out.println("Can't find file");
            }

        } catch (Exception e) {
            System.out.println("Error:  " + e);
        }

    }

}
