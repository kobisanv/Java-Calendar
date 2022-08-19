/** Date: 2021.06.07
 * Name: Kobisan Vinotharupan | File: FinalMajorAssign_KobisanV
 * Function: A Gregorian Calendar functional from 1900:
 * How it Works: a) display a calendar for inputted month and year
                 b) display a calendar for a whole year
                 c) find the day name of a given date
                 d) find future date after July 1, 2021 based on an N number of days inputted by the user
 */
package finalmajorassign_kobisanv;

import java.util.Scanner; // IMPORT SCANNER CLASS

public class FinalMajorAssign_KobisanV {

    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        boolean replay = true; // BOOLEAN FLAG FOR REPLAYABILITY
        String replay_ = ""; // STRING TO READ WHETHER USER WANTS TO REPLAY
        String desired_program = "";
        if (replay)
            mainMenu(desired_program, replay);
        if (!replay)
            fareWellMessage();
    } // END MAIN() METHOD

    public static void mainMenu(String desired_program, boolean replay) { // WELCOME MESSAGE FOR USER
        Scanner In = new Scanner(System.in); // CALL IN SCANNER
        String replay_ = "";
        String month = ""; // INT TO HOLD INPUTTED MONTH (MONTHCALENDAR, WEEKDAYNAMEFIND)
        int year = 0; // INT TO HOLD INPUTTED YEAR (MONTHCALENDAR, YEARCALENDAR, WEEKDAYNAMEFIND)
        int day = 0; // INT TO HOLD AND PRINT DAY FOR PROVIDED DATE IN WEEKDAYNAMEFIND PROGRAM
        int n = 0; // INT TO HOLD DIFFERENCE BETWEEN TARGET DATE AND INPUTTED DATE FOR
                   // FUTUREDATEFIND PROGRAM
        welcomeMessage(); // CALL IN WELCOMEMESSAGE() METHOD
        desired_program = In.next();

        if (replay && // IF REPLAY FLAG IS TRUE AND THE DESIRED PROGRAM IS VALID, RUN DESIRED PROGRAM
                (desired_program.equalsIgnoreCase("monthCalendar") || desired_program.equalsIgnoreCase("yearCalendar")
                        || desired_program.equalsIgnoreCase("weekDayNameFind")
                        || desired_program.equalsIgnoreCase("futureDateFind"))) {
            if (desired_program.equalsIgnoreCase("monthCalendar"))
                monthCalendar(month, year);
            if (desired_program.equalsIgnoreCase("yearCalendar"))
                yearCalendar(year);
            if (desired_program.equalsIgnoreCase("weekDayNameFind"))
                weekDayNameFind(month, day, year);
            if (desired_program.equalsIgnoreCase("futureDateFind"))
                futureDateFind(n);
        }
        else if (!replay && replay_.equalsIgnoreCase("No"))
            fareWellMessage();
    } // END MAINMENU() METHOD

    public static void welcomeMessage() {
        System.out.println(
                "************************************\nA Calendar By: Kobisan Vinotharupan\n************************************");
        System.out.println("Welcome to the Gregorian Calendar Application.\n");
        System.out.println("\nmonthCalendar: Shows a calendar for inputted year and month\n"
                + "\nyearCalendar: Shows a calendar for inputted year\n"
                + "\nweekDayNameFind: Finds what day a date is on\n"
                + "\nfutureDateFind: Find a date after a nth amount of days from July 1st 2021 \n\nPlease pick what program you want to run in this application:");
    } // END WELCOMEMESSAGE() METHOD

    public static void spacing(int spacing) {
        if (spacing == 1) { // IF SPACING IS 1, SPACE EIGHT TIMES AS STARTING DAY IS TUESDAY
            System.out.printf("%8s", " ");
        }
        if (spacing == 2) { // IF SPACING IS 2, SPACE SIXTEEN TIMES AS STARTING DAY IS WEDNESDAY
            System.out.printf("%16s", " ");
        }
        if (spacing == 3) { // IF SPACING IS 3, SPACE TWENTY FOUR TIMES AS STARTING DAY IS THURSDAY
            System.out.printf("%24s", " ");
        }
        if (spacing == 4) { // IF SPACING IS 4, SPACE THIRTY TWO TIMES AS STARTING DAY IS FRIDAY
            System.out.printf("%32s", " ");
        }
        if (spacing == 5) { // IF SPACING IS 5, SPACE FORTY TIMES AS STARTING DAY IS SATURDAY
            System.out.printf("%40s", " ");
        }
        if (spacing == 6) { // IF SPACING IS 6, SPACE FORTY EIGHT TIMES AS STARTING DAY IS SUNDAY
            System.out.printf("%48s", " ");
        }
    } // END SPACING() METHOD

    public static boolean ifLeapYear(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    } // END IFLEAPYEAR() METHOD

    public static int month_naming(String month) {
        String month_names[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        if (month.equalsIgnoreCase(month_names[0])) // IF JANUARY
            return 1;
        if (month.equalsIgnoreCase(month_names[1])) // IF FEBRUARY
            return 2;
        if (month.equalsIgnoreCase(month_names[2])) // IF MARCH
            return 3;
        if (month.equalsIgnoreCase(month_names[3])) // IF APRIL
            return 4;
        if (month.equalsIgnoreCase(month_names[4])) // IF MAY
            return 5;
        if (month.equalsIgnoreCase(month_names[5])) // IF JUNE
            return 6;
        if (month.equalsIgnoreCase(month_names[6])) // IF JULY
            return 7;
        if (month.equalsIgnoreCase(month_names[7])) // IF AUGUST
            return 8;
        if (month.equalsIgnoreCase(month_names[8])) // IF SEPTEMBER
            return 9;
        if (month.equalsIgnoreCase(month_names[9])) // IF OCTOBER
            return 10;
        if (month.equalsIgnoreCase(month_names[10])) // IF NOVEMBER
            return 11;
        if (month.equalsIgnoreCase(month_names[11])) // IF DECEMBER
            return 12;
        return 0;
    } // END MONTHNAMING() METHOD

    public static void calendar_title(int month_asnum, int year) {
        String month_names[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        if (month_asnum == 1)
            System.out.print("\n      " + month_names[0] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 2)
            System.out.print("\n      " + month_names[1] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 3)
            System.out.print("\n      " + month_names[2] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 4)
            System.out.print("\n      " + month_names[3] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 5)
            System.out.print("\n      " + month_names[4] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 6)
            System.out.print("\n      " + month_names[5] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 7)
            System.out.print("\n      " + month_names[6] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 8)
            System.out.print("\n      " + month_names[7] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 9)
            System.out.print("\n      " + month_names[8] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 10)
            System.out.print("\n      " + month_names[9] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 11)
            System.out.print("\n      " + month_names[10] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
        if (month_asnum == 12)
            System.out.print("\n      " + month_names[11] + "  " + year + "\n"); // DISPLAY CALENDAR TITLE
    } // END CALENDAR_TITLE() METHOD

    public static void ifMonth_30(int year, int spacing) {
        spacing(spacing);
        for (int i = 1; i <= 30; i++) { // IF MONTH IS APRIL, JUNE, SEPTEMBER, OR NOVEMBER DISPLAY 30 DAYS
            System.out.printf("%8d", i);
            if ((spacing + i) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    } // THIS METHOD IS USED IF MONTH HAS 30 DAYS

    public static void ifMonth_31(int year, int spacing) {
        spacing(spacing);
        for (int i = 1; i <= 31; i++) { // IF MONTH IS JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, OR DECEMBER DISPLAY
                                        // 31 DAYS
            System.out.printf("%8d", i);
            if ((spacing + i) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    } // THIS METHOD IS USED IF MONTH HAS 31 DAYS

    public static void ifMonth_Feb(int year, int spacing) {
        if (ifLeapYear(year)) {
            spacing(spacing);
            for (int i = 1; i <= 29; i++) { // IF MONTH IS FEBRUARY AND IT IS LEAPYEAR, DISPLAY 29 DAYS
                System.out.printf("%8d", i);
                if ((spacing + i) % 7 == 0)
                    System.out.println();
            }
        } // IF LEAPYEAR
        else {
            spacing(spacing);
            for (int i = 1; i <= 28; i++) { // IF MONTH IS FEBRUARY AND IT'S NOT A LEAPYEAR, DISPLAY 28 DAYS
                System.out.printf("%8d", i);
                if ((spacing + i) % 7 == 0)
                    System.out.println();
            }
        }
        /* IF NOT A LEAPYEAR */ System.out.println();
    } // THIS METHOD IS USED IF MONTH IS FEBRUARY (PRINTS OUT 28 DAYS OR 29 DAYS
      // (DEPENDENT ON IFLEAPYEAR() METHOD))

    public static void fareWellMessage() {
        System.out.println("\n******************************");
        System.out.println("Bye, we hope to see you again!");
        System.out.println("******************************");
    } // END FAREWELLMESSAGE() METHOD

    public static void replayMessage(String replay_, boolean replay) {
        replay = false;
        Scanner In = new Scanner(System.in);
        String desired_program = "";
        System.out.println("\nThank you for using the program.");
        System.out.println("Would you like to play again? (Yes Or No)");
        replay_ = In.next();
        if (replay_.equalsIgnoreCase("Yes")) {
            replay = true;
            mainMenu(desired_program, true);
        } else {
            replay = false;
            fareWellMessage();
        }
        System.out.println("\n");
    } // END REPLAYMESSAGE() METHOD

    public static void monthCalendar(String month, int year) { // MONTHCALENDAR PROGRAM: DISPLAYS A CALENDAR FOR DESIRED
                                                               // MONTH AND YEAR
        String replay_ = "";
        boolean replay = true; // VARIABLES TO ALLOW FOR REPLAY
        Scanner In = new Scanner(System.in); // CALL IN SCANNER
        int month_asnum = 0; // INT TO HOLD INPUTTED MONTH AS NUMBER
        String desired_program = "";
        System.out.println(
                "\nThis is the monthCalendar program. Put a month and an year and you will get a calendar of it. Press ENTER."); // WELCOME MESSAGE FOR PROGRAM
        In.nextLine(); // CLEAR BUFFER
        do {
            System.out.print("Enter month: ");
            month = In.nextLine(); // MONTH INPUT
        } while (!(month.equalsIgnoreCase("january")) && !(month.equalsIgnoreCase("february"))
                && !(month.equalsIgnoreCase("march")) && !(month.equalsIgnoreCase("april")) &&
                !(month.equalsIgnoreCase("may")) && !(month.equalsIgnoreCase("june"))
                && !(month.equalsIgnoreCase("july")) && !(month.equalsIgnoreCase("august")) &&
                !(month.equalsIgnoreCase("september")) && !(month.equalsIgnoreCase("october"))
                && !(month.equalsIgnoreCase("november")) && !(month.equalsIgnoreCase("december")));
        do {
            System.out.print("Enter any year from 1900 and on: ");
            year = In.nextInt();
        } while (year < 1900); // YEAR INPUT
        In.nextLine(); // CLEAR BUFFER
        month_asnum = month_naming(month); // SETUP OF MONTH
        int total_days = 0; // VARIABLE TO HOLD TOTAL NUMBER OF DAYS
        int spacing = 0; // DETERMINES HOW MUCH SPACING IS NEEDED ACCORDING TO THE STARTING WEEKDAY

        if ((year >= 1900) && (month_asnum > 0 && month_asnum < 13)) { // IF INPUTTED YEAR IS EQUAL OR GREATER THAN 1900
                                                                       // AND THE INPUTTED MONTH IS VALID, RUN
            for (int i = 1900; i < year; i++) {
                if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                    total_days += 366; // IF IT IS LEAP YEAR, ADD 366 DAYS TO TOTAL NUMBER OF DAYS
                } else
                    total_days += 365; // ELSE, ADD 365 DAYS TO TOTAL NUMBER OF DAYS
            } // END YEAR CALCULATION FOR LOOP
            for (int j = 1; j < month_asnum; j++) {
                switch (j) {
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        total_days += 30;
                        break; // IF MONTH IS APRIL, JUNE, SEPTEMBER, OR NOVEMBER, ADD 30 DAYS TO TOTAL NUMBER
                               // OF DAYS
                    case 2:
                        if (ifLeapYear(year)) { // IF MONTH IS FEBRUARY AND IT IS A LEAP YEAR, ADD 29 DAYS TO TOTAL
                                                // NUMBER OF DAYS
                            total_days += 29;
                        } else
                            total_days += 28;
                        break; // ELSE, ADD 28 TO TOTAL NUMBER OF DAYS
                    default:
                        total_days += 31;
                        break; // IF MONTH IS JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, OR DECEMBER, ADD 31
                               // TO TOTAL NUMBER OF DAYS
                }
            } // END MONTH CALCULATION FOR LOOP

            spacing = total_days % 7; // FIND REMAINDER OF TOTAL NUMBER OF DAYS TO DETERMINE THE STARTING DAY
            System.out.println();
            calendar_title(month_asnum, year);
            System.out.println("      **************\n");
            System.out.println("      Mon    Tues     Wed    Thurs    Fri     Sat     Sun"); // DISPLAY DAYS
            switch (month_asnum) {
                case 4:
                case 6:
                case 9:
                case 11:
                    ifMonth_30(year, spacing);
                    break; // IF MONTH IS APRIL, JUNE, SEPTEMBER, NOVEMBER

                case 2:
                    ifMonth_Feb(year, spacing);
                    break; // IF MONTH IS FEBRUARY

                default:
                    ifMonth_31(year, spacing);
                    break; // IF MONTH IS JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER
            }
            replayMessage(replay_, replay);
        }
    } // END MONTHCALENDAR() METHOD

    public static void yearCalendar(int year) { // YEARCALENDAR(): DISPLAYS CALENDAR BASED ON INPUTTED YEAR
        String replay_ = "";
        boolean replay = true; // VARIABLES TO ALLOW FOR REPLAY
        Scanner In = new Scanner(System.in); // CALL IN SCANNER
        String desired_program = "";
        String month_names[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        System.out.println("This is the yearCalendar program. This will display a calendar on the inputted year.");
        do {
            System.out.print("Enter year (only compatible if at least 1900): ");
            year = In.nextInt();
        } while (year <= 1899); // GAIN USER INPUT ON YEAR
        int total_days = 0; // TOTAL NUMBER OF DAYS
        int month_num = 1; // INT TO HOLD THE MONTH AS NUMBER
        int spacing = 0; // DETERMINES HOW MUCH SPACING BASED ON STARTING DAY

        if (year >= 1900) {
            for (int i = 1900; i < year; i++) {
                if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
                    total_days += 366; // IF IT IS LEAP YEAR, ADD 366 DAYS TO TOTAL NUMBER OF DAYS
                else
                    total_days += 365; // ELSE, ADD 365 DAYS TO TOTAL NUMBER OF DAYS
            } // END YEAR CALCULATION FOR LOOP

            System.out.println("      Calendar of " + year + "\n");
            for (month_num = 1; month_num <= 12; month_num++) {
                spacing = total_days % 7; // TAKE REMAINDER OF TOTAL DAYS TO FIND SPACING
                calendar_title(month_num, year); // TITLE FOR CALENDAR
                if (month_num == 1) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
                if (month_num == 2) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_Feb(year, spacing);
                    if (ifLeapYear(year)) {
                        total_days++;
                    }
                }
                if (month_num == 3) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
                if (month_num == 4) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_30(year, spacing);
                    total_days += 30;
                }
                if (month_num == 5) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
                if (month_num == 6) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_30(year, spacing);
                    total_days += 30;
                }
                if (month_num == 7) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
                if (month_num == 8) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
                if (month_num == 9) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_30(year, spacing);
                    total_days += 30;
                }
                if (month_num == 10) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
                if (month_num == 11) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_30(year, spacing);
                    total_days += 30;
                }
                if (month_num == 12) {
                    System.out
                            .println("      **************\n      Mon    Tues     Wed    Thurs    Fri     Sat     Sun");
                    ifMonth_31(year, spacing);
                    total_days += 31;
                }
            }
            replayMessage(replay_, replay);
        }
    } // END YEARCALENDAR() METHOD

    public static String weekDayNameFind(String month, int day, int year) { // WEEKDAYNAMEFIND(): SHOWS WHAT DAY A DATE
                                                                            // LANDS ON
        String replay_ = "";
        boolean replay = true; // VARIABLES TO ALLOW FOR REPLAY
        Scanner In = new Scanner(System.in); // CALL IN SCANNER
        String desired_program = "";
        int month_asnum = 0; // INT TO HOLD INPUTTED MONTH AS NUMBER
        int total_days = 0; // INT TO HOLD TOTAL NUMBER OF DAYS
        String month_names[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String month_str = ""; // STRING TO HOLD MONTH AS A STRING TO DISPLAY
        int name_num = 0; // INT TO HOLD THE WEEKDAY AS A NUMBER
        System.out.println("This is the weekDayNameFind program. Enter a date to find the day it is on.");
        do {
            System.out.print("Enter month: ");
            month = In.nextLine();
        } while (!(month.equalsIgnoreCase("january")) && !(month.equalsIgnoreCase("february"))
                && !(month.equalsIgnoreCase("march")) && !(month.equalsIgnoreCase("april")) &&
                !(month.equalsIgnoreCase("may")) && !(month.equalsIgnoreCase("june"))
                && !(month.equalsIgnoreCase("july")) && !(month.equalsIgnoreCase("august")) &&
                !(month.equalsIgnoreCase("september")) && !(month.equalsIgnoreCase("october"))
                && !(month.equalsIgnoreCase("november")) && !(month.equalsIgnoreCase("december"))); // MONTH INPUT
        month_asnum = month_naming(month); // SETUP OF MONTH
        do {
            System.out.print("Enter any year from 1900 and on: ");
            year = In.nextInt();
        } while (year < 1900); // YEAR INPUT
        if (month_asnum == 4 || month_asnum == 6 || month_asnum == 9 || month_asnum == 11) {
            do {
                System.out.print("Enter a date: ");
                day = In.nextInt();
            } while (day > 30); // IF APRIL, JUNE, SEPTEMBER, NOVEMBER, VALID FOR 30 DAYS
        } else if (month_asnum == 2) {
            if (ifLeapYear(year)) {
                do {
                    System.out.print("Enter a date: ");
                    day = In.nextInt();
                } while (day > 29); // IF LEAP YEAR AND FEBRUARY, NUMBER OF VALID DAYS IS 29
            } else {
                do {
                    System.out.print("Enter a date: ");
                    day = In.nextInt();
                } while (day > 28); // IF NOT LEAP YEAR AND FEBRUARY, NUMBER OF VALID DAYS IS 28
            }
        } else {
            do {
                System.out.print("Enter a date: ");
                day = In.nextInt();
            } while (day > 31); // ANY OTHER MONTH VALID FOR 31 DAYS
        }

        for (int i = 1900; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                total_days += 366; // IF IT IS LEAP YEAR, ADD 366 DAYS TO TOTAL NUMBER OF DAYS
            } else
                total_days += 365;
            /* ELSE, ADD 365 DAYS TO TOTAL NUMBER OF DAYS */ } // END YEAR CALCULATION FOR LOOP
        for (int j = 1; j < month_asnum; j++) {
            switch (j) {
                case 4:
                case 6:
                case 9:
                case 11:
                    total_days += 30;
                    break;// IF MONTH IS APRIL, JUNE, SEPTEMBER, OR NOVEMBER, ADD 30 DAYS TO TOTAL NUMBER
                          // OF DAYS
                case 2:
                    if (ifLeapYear(year)) { // IF MONTH IS FEBRUARY AND IT IS A LEAP YEAR, ADD 29 DAYS TO TOTAL NUMBER
                                            // OF DAYS
                        total_days += 29;
                    } else
                        total_days += 28;
                    break; // ELSE, ADD 28 TO TOTAL NUMBER OF DAYS
                default:
                    total_days += 31;
                    break; // IF MONTH IS JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, OR DECEMBER, ADD 31
                           // TO TOTAL NUMBER OF DAYS
            }
        } // END MONTH CALCULATION FOR LOOP
        total_days = total_days + (day - 1); // CALCULATION FOR TOTALDAYS
        name_num = (total_days % 7) + 1; // MODULATE TOTAL DAYS BY SEVEN TO GET A NUMBER TO REPRESENT THE WEEKDAY THE
                                         // DATE WILL LAND ON
        if (month.equalsIgnoreCase(month_names[0]))
            month_str = ("January");
        if (month.equalsIgnoreCase(month_names[1]))
            month_str = ("February");
        if (month.equalsIgnoreCase(month_names[2]))
            month_str = ("March");
        if (month.equalsIgnoreCase(month_names[3]))
            month_str = ("April");
        if (month.equalsIgnoreCase(month_names[4]))
            month_str = ("May");
        if (month.equalsIgnoreCase(month_names[5]))
            month_str = ("June");
        if (month.equalsIgnoreCase(month_names[6]))
            month_str = ("July");
        if (month.equalsIgnoreCase(month_names[7]))
            month_str = ("August");
        if (month.equalsIgnoreCase(month_names[8]))
            month_str = ("September");
        if (month.equalsIgnoreCase(month_names[9]))
            month_str = ("October");
        if (month.equalsIgnoreCase(month_names[10]))
            month_str = ("November");
        if (month.equalsIgnoreCase(month_names[11]))
            month_str = ("December");
        System.out.println();
        if (name_num == 1)
            System.out.println(month_str + "." + day + "." + year + " lands on Monday."); // IF WEEKDAY IS MONDAY
        if (name_num == 2)
            System.out.println(month_str + "." + day + "." + year + " lands on Tuesday."); // IF WEEKDAY IS TUESDAY
        if (name_num == 3)
            System.out.println(month_str + "." + day + "." + year + " lands on Wednesday."); // IF WEEKDAY IS WEDNESDAY
        if (name_num == 4)
            System.out.println(month_str + "." + day + "." + year + " lands on Thursday."); // IF WEEKDAY IS THURSDAY
        if (name_num == 5)
            System.out.println(month_str + "." + day + "." + year + " lands on Friday."); // IF WEEKDAY IS FRIDAY
        if (name_num == 6)
            System.out.println(month_str + "." + day + "." + year + " lands on Saturday."); // IF WEEKDAY IS SATURDAY
        if (name_num == 7)
            System.out.println(month_str + "." + day + "." + year + " lands on Sunday."); // IF WEEKDAY IS SUNDAY
        replayMessage(replay_, replay);
        return null;
    } // END WEEKDAYNAMEFIND() METHOD

    public static void futureDateFind(int n) { // JUMPS N AMOUNT OF DAYS INTO THE FUTURE STARTING FROM JULY 1ST 2021
        String replay_ = "";
        boolean replay = true; // VARIABLES TO ALLOW FOR REPLAY
        Scanner In = new Scanner(System.in); // CALL IN SCANNER
        String desired_program = "";
        int counter = 0; // COUNTER VARIABLE FOR WHILE LOOP
        int day = 1;
        int month = 7;
        int year = 2021; // SETUP OF INITIAL DATE (JULY 1ST 2021)
        int numofDays_month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // ARRAY TO HOLD AMOUNT OF DAYS
                                                                                       // IN MONTH (PUT 0 SO FIRST INDEX
                                                                                       // IS JANUARY AND IS ALIGNED)
        if (ifLeapYear(year)) {
            numofDays_month[2] = 29;
        } // IF LEAPYEAR AND FEBRUARY, INCREMENT SECOND INDEX BY 1
        String month_names[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        if (month < 0 || month > 12 || day < 0 || day > numofDays_month[month] || year < 0)
            System.out.println("{ERROR} INVALID VALUES {ERROR}\nPLEASE TRY AGAIN!"); // IF ERROR
        else {
            System.out.println("This is the futureDateFind program. It will find a date starting from July 1st 2021.");
            System.out.println("Enter how many days you want to move forward from July 1st 2021.");
            n = In.nextInt(); // USER INPUT ON HOW MANY DAYS THE PROGRAM IS GOING TO MOVE FORWARD

            do {
                day++; // WITH EACH LOOP, INCREMENT DAY BY ONE
                if (month > 12) { // IF MONTH IS OVER 12
                    month = 1; // SET MONTH BACK TO 1
                    year++; // INCREMENT YEAR BY ONE
                    if (ifLeapYear(year)) {
                        numofDays_month[2] = 29;
                    } // IF LEAP YEAR SECOND INDEX SHOULD BE 29
                    else {
                        numofDays_month[2] = 28;
                    } /* ELSE IT SHOULD BE 28 */
                }
                if (day > numofDays_month[month]) { // IF DAY IS HIGHER THAN ANY NUMBER IN THE MONTHS ARRAY
                                                    // (SPECIFICALLY 31)
                    day = 1; // SET DAY BACK TO 1
                    month++;
                } /* INCREMENT MONTH BY 1 */
                counter++; // INCREMENT COUNTER BY ONE
            } while (counter <= n - 1); // ONLY RUNS WHILE COUNTER IS NOT EQUAL TO N

            if (month == 1)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[0] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 2)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[1] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 3)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[2] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 4)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[3] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 5)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[4] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 6)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[5] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 7)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[6] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 8)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[7] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 9)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[8] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 10)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[9] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                         // FUTURE
                                                                                                                         // DATE
            if (month == 11)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[10] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                 // FUTURE
                                                                                                                 // DATE
            if (month == 12)
                System.out.println("\nAfter " + n + " days, it will be " + month_names[11] + "/" + day + "/" + year + "."); // DISPLAY
                                                                                                                 // FUTURE
                                                                                                                 // DATE
            replayMessage(replay_, replay);

        } // END MAIN ELSE STATEMENT FOR FUTUREDATEFIND
    } // END FUTUREDATEFIND() METHOD
} // END CLASS
