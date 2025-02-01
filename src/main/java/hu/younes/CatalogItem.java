package hu.younes;

public interface CatalogItem {
    String getItemInfo();
    boolean matches(String keyword);

}
