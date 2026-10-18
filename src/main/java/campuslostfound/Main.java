package campuslostfound;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LostFoundSystem system = new LostFoundSystem();

        int choice=0;

        do {

            System.out.println("\n=================================");
            System.out.println("      CAMPUS LOST & FOUND");
            System.out.println("=================================");
            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. View Lost Items");
            System.out.println("4. View Found Items");
            System.out.println("5. Search Lost Item");
            System.out.println("6. Search Found Item");
            System.out.println("7. Find Possible Matches");
            System.out.println("8. Exit");           
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            try {
    choice = Integer.parseInt(scanner.next());
} catch (NumberFormatException e) {
    System.out.println("Invalid choice. Please enter a number from 1 to 8.");
    scanner.nextLine();
    continue;
}
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n--- Report Lost Item ---");

                    System.out.print("Enter item ID: ");
                    int lostId;
                    while (true) {
                    String input = scanner.next();
                    try {
                    lostId = Integer.parseInt(input);
                    break;
                    } 
                     catch (NumberFormatException e) {
                     System.out.print("Invalid ID. Enter a numeric ID: ");
                  }
                }
                    scanner.nextLine();

                    System.out.print("Enter item name: ");
                    String lostName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String lostDescription = scanner.nextLine();

                    System.out.print("Enter location lost: ");
                    String lostLocation = scanner.nextLine();

                    System.out.print("Enter date lost: ");
                    String lostDate = scanner.nextLine();

                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();

                    LostItem lostItem = new LostItem(
                            lostId,
                            lostName,
                            lostDescription,
                            lostLocation,
                            lostDate,
                            ownerName
                    );

                    system.addLostItem(lostItem);

                    break;

                case 2:

                    System.out.println("\n--- Report Found Item ---");

                    System.out.print("Enter item ID: ");
                    int foundId;
while (true) {
    String input = scanner.next();
    try {
        foundId = Integer.parseInt(input);
        break;
    } catch (NumberFormatException e) {
        System.out.print("Invalid ID. Enter a numeric ID: ");
    }
}
                    scanner.nextLine();

                    System.out.print("Enter item name: ");
                    String foundName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String foundDescription = scanner.nextLine();

                    System.out.print("Enter location found: ");
                    String foundLocation = scanner.nextLine();

                    System.out.print("Enter date found: ");
                    String foundDate = scanner.nextLine();

                    System.out.print("Enter finder name: ");
                    String finderName = scanner.nextLine();

                    FoundItem foundItem = new FoundItem(
                            foundId,
                            foundName,
                            foundDescription,
                            foundLocation,
                            foundDate,
                            finderName
                    );

                    system.addFoundItem(foundItem);

                    break;

                case 3:

                    system.displayLostItems();

                    break;

                case 4:

                    system.displayFoundItems();

                    break;

                case 5:

                    System.out.print("\nEnter item name to search: ");
                    String lostSearch = scanner.nextLine();

                    system.searchLostItem(lostSearch);

                    break;

                case 6:

                    System.out.print("\nEnter item name to search: ");
                    String foundSearch = scanner.nextLine();

                    system.searchFoundItem(foundSearch);

                    break;

                case 7:
               system.findMatches();
                break;

                 case 8:
                    System.out.println("\nThank you for using Campus Lost & Found!");
                    break;

                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 8);

        scanner.close();
    }
}