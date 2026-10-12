package campuslostfound;

import java.util.ArrayList;

public class LostFoundSystem {

    private ArrayList<LostItem> lostItems;
    private ArrayList<FoundItem> foundItems;

    public LostFoundSystem() {
        lostItems = new ArrayList<>();
        foundItems = new ArrayList<>();
    }

    // Add a lost item
    public void addLostItem(LostItem item) {
        lostItems.add(item);
        System.out.println("Lost item added successfully!");
    }

    // Add a found item
    public void addFoundItem(FoundItem item) {
        foundItems.add(item);
        System.out.println("Found item added successfully!");
    }

    // Display all lost items
    public void displayLostItems() {

        if (lostItems.isEmpty()) {
            System.out.println("No lost items available.");
            return;
        }

        System.out.println("\n========== LOST ITEMS ==========");

        for (LostItem item : lostItems) {
            item.displayItem();
        }
    }

    // Display all found items
    public void displayFoundItems() {

        if (foundItems.isEmpty()) {
            System.out.println("No found items available.");
            return;
        }

        System.out.println("\n========== FOUND ITEMS ==========");

        for (FoundItem item : foundItems) {
            item.displayItem();
        }
    }

    // Search lost items by name
    public void searchLostItem(String keyword) {

        boolean found = false;

        for (LostItem item : lostItems) {

            if (item.getItemName().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                item.displayItem();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching lost item found.");
        }
    }

    // Search found items by name
    public void searchFoundItem(String keyword) {

        boolean found = false;

        for (FoundItem item : foundItems) {

            if (item.getItemName().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                item.displayItem();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching found item found.");
        }
    }
}