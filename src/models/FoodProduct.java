package models;

public class FoodProduct {
    private int id;
    private String SKU; //stock keeping unit (a unique code for each product)
    private String description;
    private String category;
    private int price;
    public FoodProduct(String SKU, String description, String category, int price) {
        this.SKU = SKU;
        this.description = description;
        this.category = category;
        this.price = price;
    }
    public FoodProduct(int id, String SKU, String description, String category, int price) {
        this.id = id;
        this.SKU = SKU;
        this.description = description;
        this.category = category;
        this.price = price;
    }
    public int getID(){
        return id;
    }
    public String getSKU(){
        return SKU;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return category;
    }
    public int getPrice(){
        return price;
    }
    public void setSKU(String sku){
        this.SKU = sku;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String toString(){
        return "Product={id="+id+", SKU='"+SKU+"', description='"+description+"', category='"+category+"', price="+price+"}";
    }
}