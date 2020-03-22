package plannermain;

public class Calendar {

    private String month;
    private int day;
    private int year;
    private int hour;
    private int min;
    private String message;

    UserInput user = new UserInput();

    public void setMonth(String m) {
        if (m.equals("Jan") || m.equals("Feb") || m.equals("Mar") || m.equals("Apr") || m.equals("May") || m.equals("Jun") || m.equals("Jul") || m.equals("Aug")
                || m.equals("Sep") || m.equals("Oct") || m.equals("Nov") || m.equals("Dec")) {

            month = m;
        } else {
            System.out.println("Month choice doesn't exist. Try again: ");
            String n = user.getString(1, 20);
            setMonth(n);
        }
    }

    public String getMonth() {
        return month;
    }

    public void setDay(int d) {
        String a = getMonth();
        if (a.equals("Feb")) {

            if (d <= 29 && d >= 1) {
                this.day = d;
            } else {
                System.out.println("Day choice doesn't exist. Try again: ");
                int n = user.getInt();
                setDay(n);
            }
        }
        if (a.equals("Apr") || a.equals("Jun") || a.equals("Sep") || a.equals("Nov")) {

            if (d <= 30 && d >= 1) {
                this.day = d;
            } else {
                System.out.println("Day choice doesn't exist. Try again: ");
                int n = user.getInt();
                setDay(n);
            }
        }
        if (a.equals("Jan") || a.equals("Mar") || a.equals("May") || a.equals("Jul") || a.equals("Aug") || a.equals("Oct") || a.equals("Dec")) {

            if (d <= 31 && d >= 1) {
                this.day = d;
            } else {
                System.out.println("Day choice doesn't exist. Try again: ");
                int n = user.getInt();
                setDay(n);

            }
        }

    }

    public int getDay() {
        return day;
    }

    public void setYear(int y) {
        if (y <= 27000 && y >= 1) {
            this.year = y;

        } else {
            System.out.println("Year choice isn't available. Try again: ");
            int a = user.getInt();
            setYear(a);
        }

    }

    public int getYear() {
        return year;
    }

    public void setHour(int h) {
        if (h <= 24 && h >= 0) {
            this.hour = h;
        } else {
            System.out.println("Hour choice doesn't exist. Try again: ");
            int a = user.getInt();
            setHour(a);
        }

    }

    public int getHour() {
        return hour;

    }

    public void setMin(int m) {
        if (m <= 60 && m >= 00) {
            this.min = m;
        } else {
            System.out.println("Minute choice doesn't exist. Try again: ");
            int a = user.getInt();
            setMin(a);

        }

    }

    public int getMin() {
        return min;
    }

    public void setMessage(String message) {
        if (message.length() <= 100) {
            this.message = message;

        } else {
            System.out.println("Message is too long. Try again: ");
            this.message = message.substring(0, 100);

        }

    }

    public String getMessage() {
        return message;
    }

}
