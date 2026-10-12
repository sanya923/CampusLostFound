package campuslostfound;

public class FoundItem {

    private int id;
    private String itemName;
    private String description;
    private String location;
    private String date;
    private String finderName;

    public FoundItem(int id, String itemName, String description,
                     String location, String date, String finderName) {

        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.date = date;
        this.finderName = finderName;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getFinderName() {
        return finderName;
    }

    public void displayItem() {
        System.out.println("--------------------------------");
        System.out.println("Found Item ID  : " + id);
        System.out.println("Item Name      : " + itemName);
        System.out.println("Description    : " + description);
        System.out.println("Location       : " + location);
        System.out.println("Date Found     : " + date);
        System.out.println("Finder         : " + finderName);
        System.out.println("--------------------------------");
    }
}