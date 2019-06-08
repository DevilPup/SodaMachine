package sodamachine;

public class Soda {
    private String brand = "";
    private int price = 0;
    private boolean inStock = false;

    public Soda(){
        this("",125,false);
    }
    
    public Soda(String brand, int price, boolean inStock) {
        this.brand = brand;
        this.price = price;
        this.inStock = inStock;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setStock(boolean inStock){
        this.inStock = inStock;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public boolean getStock(){
        return inStock;
    }
    
    @Override
    public String toString(){
        return String.format("%s $%.2f",brand,((double)price)/100);
    }
}
