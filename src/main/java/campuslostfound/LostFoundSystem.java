
package campuslostfound;

import java.io.*;
import java.util.ArrayList;

public class LostFoundSystem {

    private ArrayList<LostItem> lostItems;
    private ArrayList<FoundItem> foundItems;

    private static final String LOST_FILE = "data/lost_items.txt";
    private static final String FOUND_FILE = "data/found_items.txt";

    public LostFoundSystem() {
        lostItems = new ArrayList<>();
        foundItems = new ArrayList<>();

        loadLostItems();
        loadFoundItems();
    }

    // Add a lost item and save it
    public void addLostItem(LostItem item) {
        lostItems.add(item);
        saveLostItems();
        System.out.println("Lost item added successfully!");
    }

    // Add a found item and save it
    public void addFoundItem(FoundItem item) {
        foundItems.add(item);
        saveFoundItems();
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

    // Create the data folder if it does not exist
    private void createDataFolder() {
        File folder = new File("data");

        if (!folder.exists() && !folder.mkdirs()) {
            System.out.println("Warning: Could not create data folder.");
        }
    }

    // Save lost items
    private void saveLostItems() {
        createDataFolder();

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(LOST_FILE))) {

            for (LostItem item : lostItems) {
                writer.println(
                    item.getId() + "|" +
                    encode(item.getItemName()) + "|" +
                    encode(item.getDescription()) + "|" +
                    encode(item.getLocation()) + "|" +
                    encode(item.getDate()) + "|" +
                    encode(item.getOwnerName())
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving lost items: "
                    + e.getMessage());
        }
    }

    // Save found items
    private void saveFoundItems() {
        createDataFolder();

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FOUND_FILE))) {

            for (FoundItem item : foundItems) {
                writer.println(
                    item.getId() + "|" +
                    encode(item.getItemName()) + "|" +
                    encode(item.getDescription()) + "|" +
                    encode(item.getLocation()) + "|" +
                    encode(item.getDate()) + "|" +
                    encode(item.getFinderName())
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving found items: "
                    + e.getMessage());
        }
    }

    // Load lost items
    private void loadLostItems() {
        File file = new File(LOST_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 6) {
                    try {
                        lostItems.add(new LostItem(
                            Integer.parseInt(data[0]),
                            decode(data[1]),
                            decode(data[2]),
                            decode(data[3]),
                            decode(data[4]),
                            decode(data[5])
                        ));
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Skipping invalid lost item record.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading lost items: "
                    + e.getMessage());
        }
    }

    // Load found items
    private void loadFoundItems() {
        File file = new File(FOUND_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 6) {
                    try {
                        foundItems.add(new FoundItem(
                            Integer.parseInt(data[0]),
                            decode(data[1]),
                            decode(data[2]),
                            decode(data[3]),
                            decode(data[4]),
                            decode(data[5])
                        ));
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Skipping invalid found item record.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading found items: "
                    + e.getMessage());
        }
    }

    // Encode text safely for storage in a delimited file
    private String encode(String value) {
        return value.replace("%", "%25")
                    .replace("|", "%7C")
                    .replace("\n", "%0A")
                    .replace("\r", "%0D");
    }

    // Restore encoded text
    private String decode(String value) {
        return value.replace("%0D", "\r")
                    .replace("%0A", "\n")
                    .replace("%7C", "|")
                    .replace("%25", "%");
    }

    public void findMatches() {
        boolean matchFound = false;

        System.out.println("\n========== POSSIBLE MATCHES ==========");

        if (lostItems.isEmpty() || foundItems.isEmpty()) {
            System.out.println(
                "You need at least one lost item and one found item to find matches."
            );
            return;
        }

        for (LostItem lost : lostItems) {
            for (FoundItem found : foundItems) {

                String lostName = lost.getItemName().toLowerCase().trim();
                String foundName = found.getItemName().toLowerCase().trim();

                String lostLocation = lost.getLocation().toLowerCase().trim();
                String foundLocation = found.getLocation().toLowerCase().trim();

                boolean nameMatches =
                    lostName.contains(foundName) ||
                    foundName.contains(lostName);

                boolean locationMatches =
                    lostLocation.equals(foundLocation);

                if (nameMatches && locationMatches) {
                    matchFound = true;

                    System.out.println("\nPossible match found!");
                    System.out.println("Lost item:");
                    lost.displayItem();

                    System.out.println("Found item:");
                    found.displayItem();
                }
            }
        }

        if (!matchFound) {
            System.out.println("No possible matches found yet.");
        }
    }

}
