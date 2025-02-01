package hu.younes;

public abstract class Item implements CatalogItem {
    private static int idCounter = 1;
    private int id;
    private String title;

    public Item(String title) {
        this.id = idCounter++;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean matches(String keyword) {
        return title != null && title.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String getItemInfo() {
        return "ID: " + id + ", Title: " + title;
    }
}
