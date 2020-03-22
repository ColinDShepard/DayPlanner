
package plannermain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Appointment {

    Calendar calendar = new Calendar();
    UserInput userinput = new UserInput();
    HashMap<String, ArrayList<String>> date = new HashMap<>();

    private String line = null;
    private String message = null;
    private String time = null;
    private String app = null;

    int choice = 0;

    public void createDate() {
        System.out.println("Choose month: Ex 'Jan'");
        String a = userinput.getString(1, 20);
        calendar.setMonth(a);
        String m = calendar.getMonth();

        System.out.println("Choose day: Ex '20'");
        int d = userinput.getInt();
        calendar.setDay(d);
        int b = calendar.getDay();

        System.out.println("Choose year: Ex '2020'");
        int y = userinput.getInt();
        calendar.setYear(y);
        int t = calendar.getYear();

        String line = m + " " + b + " " + t;
        this.line = line;
        System.out.println(line);
    }

    public String getDate() {
        return line;
    }

    public void createEvent() {
        System.out.println("Input the event on this day");
        String a = userinput.getString(1, 20);
        calendar.setMessage(a);

        String message = " " + a;
        this.message = message;

    }

    public String getEvent() {
        return message;
    }

    public void setApp() {
        String app = getTime() + "=" + getEvent();

    }

    public String getApp() {
        return app;
    }

    public void createTime() {
        System.out.println("What is the hour of the appointment military time: Ex '13' ");
        int h = userinput.getInt();
        calendar.setHour(h);
        int hour = calendar.getHour();

        System.out.println("What is the minute of the appointment: Ex '55' ");
        int m = userinput.getInt();
        calendar.setMin(m);
        int min = calendar.getMin();

        String padhour = String.format("%02d", hour);
        String padmin = String.format("%02d", min);

        String t = padhour + ":" + padmin + " ";
        this.time = t;
        System.out.println(t);
    }

    public String getTime() {
        return time;
    }

    public void fillHash() {
        createDate();
        System.out.println("How many appointments will be added: ");
        int choice = userinput.getInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < choice; i++) {

            createTime();
            createEvent();

            String app = getTime() + "=" + getEvent();

            list.add(app);

            Collections.sort(list);
            date.put(getDate(), list);

        }

    }

    public void editAppointment() {

        System.out.println("Choose the appointment to edit: ");
        String a = userinput.getString(1, 20);
        ArrayList<String> list;

        if (date.containsKey(a)) {
            list = date.get(a);

            System.out.println("Write appointment to add: ");
            createTime();
            createEvent();
            setApp();

            String app = getTime() + "=" + getEvent();
            list.add(app);
            System.out.println("List =" + list);

            Collections.sort(list);
            System.out.println(list);

        } else {
            System.out.println("Couldn't find date");

        }
    }

    public void deleteFile() {

        int choice = -1;

        System.out.println(date);

        System.out.println("Choose an option below: ");
        System.out.println("0: Exit program");
        System.out.println("1: Delete date");
        System.out.println("2: Delete event");

        choice = userinput.getInt();

        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("Choose date to remove: ");
                String a = userinput.getString(1, 20);
                if (date.containsKey(a)) {
                    date.remove(a);
                    System.out.println("Remaining values: " + date);
                } else {
                    System.out.println("Couldn't find date");
                }

                break;
            case 2:
                System.out.println("Choose date to delete: ");
                String b = userinput.getString(1, 20);
                ArrayList list;
                if (date.containsKey(b)) {
                    list = date.get(b);
                    System.out.println(list);
                    System.out.println("Enter to delete");
                    String c = userinput.getString(1, 20);
                    list.remove(c);
                    date.put(b, list);

                } else {
                    System.out.println("Couldn't find event");
                }

                break;

        }

    }


}
