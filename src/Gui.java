import java.util.Scanner;

public class Gui {

    // Constants representing the different menu choices
    private final int ADD_HEARING_AID = 1;
    private final int LIST_ALL_HEARING_AIDS = 2;
    private final int LOAN_OUT_HEARING_AID = 3;
    private final int DELIVER_BACK_HEARING_AID = 4;
    private final int EXIT = 5;

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     *                 If 0 is returned, the user has entered a wrong value
     */
    private int showMenu(Scanner sc)
    {
        int menuChoice = 0;
        System.out.println("\n***** Hearing Aid Central v0.1 *****\n");
        System.out.println("1. Add hearing aid");
        System.out.println("2. List all hearing aids");
        System.out.println("3. Loan out hearing aid");
        System.out.println("4. Deliver back hearing aid");
        System.out.println("5. Quit");
        System.out.println("\nPlease select from the menu.\n");

        if (sc.hasNextInt())
        {
            menuChoice = sc.nextInt();
        } else
        {
            System.out.println("You must enter a number, not text");
        }
        sc.nextLine();
        return menuChoice;
    }



    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        HearingAidCentral hearingAidCentral = new HearingAidCentral("Hearing aid central");
        boolean finished = false;
        // The while-loop will run as long as the user has not selected
        // to quit the application
        while (!finished) {
            int menuChoice = this.showMenu(sc);
            switch (menuChoice)
            {
                case ADD_HEARING_AID:
                    System.out.println("Write in the type of hearing aid:");
                    String type = sc.nextLine();
                    System.out.println("Write:\n1 if it is rented out\n2 if it is available");
                    int availability = sc.nextInt();
                    sc.nextLine();
                    if(availability == 1){
                        System.out.println("What is the name of the rent taker?");
                        String rentTaker = sc.nextLine();
                        hearingAidCentral.addNewHearingAid(type,rentTaker);
                    }
                    else if(availability == 2){
                        hearingAidCentral.addNewHearingAid(type);
                    }
                    else {
                        System.out.println("The input was not valid");
                    }
                    break;

                case LIST_ALL_HEARING_AIDS:
                    System.out.println(hearingAidCentral.toString());
                    break;

                case LOAN_OUT_HEARING_AID:
                    System.out.println("Write in the ID of the hearing aid (1001-9999)");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Write in the name of the rent taker");
                    String rentTaker = sc.nextLine();

                    boolean successful = hearingAidCentral.rentOutHearingAid(id,rentTaker);
                   if(successful){
                        System.out.println("The loan was successful");
                    }
                    else {
                        System.out.println("The loan was unsuccessful");
                    }
                    break;

                case DELIVER_BACK_HEARING_AID:
                    System.out.println("Write in the ID of the hearing aid (1001-9999");
                    id = sc.nextInt();
                    sc.nextLine();
                    successful = hearingAidCentral.endRentingAgreement(id);
                    if(successful){
                        System.out.println("The termination of the renting process was successful");
                    }
                    else {
                        System.out.println("The termination of the renting process was unsuccessful");
                    }
                    break;

                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;

                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.start();
    }
}
