package campuslostfound;

public class LostItem {

    private int id;
    private String itemName;
    private String description;
    private String location;
    private String date;
    private String ownerName;

    public LostItem(int id, String itemName, String description,
                    String location, String date, String ownerName) {

        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.date = date;
        this.ownerName = ownerName;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void displayItem() {
        System.out.println("--------------------------------");
        System.out.println("Lost Item ID   : " + id);
        System.out.println("Item Name      : " + itemName);
        System.out.println("Description    : " + description);
        System.out.println("Location       : " + location);
        System.out.println("Date Lost      : " + date);
        System.out.println("Owner          : " + ownerName);
        System.out.println("--------------------------------");
    }
}