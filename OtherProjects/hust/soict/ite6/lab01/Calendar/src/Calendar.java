import java.util.Scanner;
public class Calendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String month = ""; // Store the month
        boolean validMonth = false; // Check if the month is valid
        while(!validMonth) {
            System.out.print("Le Dong Canh Phu - 20225755 - Enter the month: ");
            String strMonth = input.nextLine();
        if(strMonth.equals("January") || strMonth.equals("Jan") || strMonth.equals("Jan.")) {
            // Solve for January
            month = "January";
            validMonth = true;
        } else if(strMonth.equals("February") || strMonth.equals("Feb") || strMonth.equals("Feb.")) {
            // Solve for February
            month = "February";
            validMonth = true;
        } else if(strMonth.equals("March") || strMonth.equals("Mar") || strMonth.equals("Mar.")) {
            // Solve for March
            month = "March";
            validMonth = true;
        } else if(strMonth.equals("April") || strMonth.equals("Apr") || strMonth.equals("Apr.")) {
            // Solve for April
            month = "April";
            validMonth = true;
        } else if(strMonth.equals("May") || strMonth.equals("May.")) {
            // Solve for May
            month = "May";
            validMonth = true;
        } else if(strMonth.equals("June") || strMonth.equals("Jun") || strMonth.equals("Jun.")) {
            // Solve for June
            month = "June";
            validMonth = true;
        } else if(strMonth.equals("July") || strMonth.equals("Jul") || strMonth.equals("Jul.")) {
            // Solve for July
            month = "July";
            validMonth = true;
        } else if(strMonth.equals("August") || strMonth.equals("Aug") || strMonth.equals("Aug.")) {
            // Solve for August
            month = "August";
            validMonth = true;
        } else if(strMonth.equals("September") || strMonth.equals("Sep") || strMonth.equals("Sep.")) {
            // Solve for September
            month = "September";
            validMonth = true;
        } else if(strMonth.equals("October") || strMonth.equals("Oct") || strMonth.equals("Oct.")) {
            // Solve for October
            month = "October";
            validMonth = true;
        } else if(strMonth.equals("November") || strMonth.equals("Nov") || strMonth.equals("Nov.")) {
            // Solve for November
            month = "November";
            validMonth = true;
        } else if(strMonth.equals("December") || strMonth.equals("Dec") || strMonth.equals("Dec.")) {
            // Solve for December
            month = "December";
            validMonth = true;
        } else if(!strMonth.isEmpty()) { // Check if the input is not empty
            try {
                int monthNumber = Integer.parseInt(strMonth); // Parse the input to integer
            switch(monthNumber) {
                case 1:
                    month = "January";
                    validMonth = true;
                    break;
                case 2:
                    month = "February";
                    validMonth = true;
                    break;
                case 3:
                    month = "March";
                    validMonth = true;
                    break;
                case 4:
                    month = "April";
                    validMonth = true;
                    break;
                case 5:
                    month = "May";
                    validMonth = true;
                    break;
                case 6:
                    month = "June";
                    validMonth = true;
                    break;
                case 7:
                    month = "July";
                    validMonth = true;
                    break;
                case 8:
                    month = "August";
                    validMonth = true;
                    break;
                case 9:
                    month = "September";
                    validMonth = true;
                    break;
                case 10:
                    month = "October";
                    validMonth = true;
                    break;
                case 11:
                    month = "November";
                    validMonth = true;
                    break;
                case 12:
                    month = "December";
                    validMonth = true;
                    break;
                default:
                    System.out.println("Invalid month. Please enter again.");
                    validMonth = false;
                    break;
            }
            } catch(NumberFormatException e) { // Catch the exception if the input is not a number
                System.out.println("Invalid month. Please enter again.");
                validMonth = false;
            } 
        }
        else { // If the input is empty
            System.out.println("Invalid month. Please enter again."); 
        }
        }
    boolean validYear = false; // Check if the year is valid
    String isLeapyear = ""; // Store the leap year
    int years = 0; // Store the year
    while(!validYear) {
        System.out.print("Le Dong Canh Phu - 20225755 - Enter the year: ");
        int year = input.nextInt();
        if(year>0 && year < 10000) {
            validYear = true;
            if(year%4==0) {
                if(year%100==0) {
                    if(year%400==0) {
                        isLeapyear = "leap";
                        years = year;
                    } else {
                        isLeapyear = "not leap";
                        years = year;
                    }
                } else {
                    isLeapyear = "leap";
                    years = year;
                }
            } else {
                isLeapyear = "not leap";
                years = year;
            }
        } else {
            validYear = false;
            System.out.println("Invalid year. Please enter again.");
        }
    }
    if(isLeapyear.equals("leap")) {
        if(month.equals("January") || month.equals("March") || month.equals("May") || month.equals("July") || month.equals("August") || month.equals("October") || month.equals("December")) {
            System.out.println("The month " + month + " in year " + years + " has 31 days.");
        } else if(month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
            System.out.println("The month " + month + " in year " + years + " has 30 days.");
        } else {
            System.out.println("The month " + month + " in year " + years + " has 29 days.");
        }
    } else {
        if(month.equals("January") || month.equals("March") || month.equals("May") || month.equals("July") || month.equals("August") || month.equals("October") || month.equals("December")) {
            System.out.println("The month " + month + " in year " + years + " has 31 days.");
        } else if(month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
            System.out.println("The month " + month + " in year " + years + " has 30 days.");
        } else {
            System.out.println("The month " + month + " in year " + years + " has 28 days.");
        }
    }
    input.close();
}
}
