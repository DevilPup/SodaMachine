import java.text.DecimalFormat;
import java.util.Scanner;

public class SodaMachine {
    
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private static double money = 0;
    private static String message = "";
    private static Soda[][] slot = new Soda[4][20];
    boolean powerOn = true;
    private static String display = " $" + df2.format(money) + "                        ";
    
    public static void main(String[] args) {
        // TODO code application logic here
        SodaMachine bill = new SodaMachine();
    }
    
    // Business up front. Fill the machine, and if the power is on,
    // Run the getMessage and then give the user a choice. Loops
    // Forever and ever and ever and ever.....
    public SodaMachine(){
        loadSoda();
        while(powerOn == true){
        System.out.print(getMessage());
        userChoice();
        }
    }
    
    // Tells slot that it's filled with soda
    public SodaMachine(Soda[][] sodas){
        this.slot = sodas;
    } 
    
    // Takes in user input, and if it's a beverage
    // It will check if you've already got enough money,
    // If money is enough, it proceeds to call dispense
    // And gives you a beverage. If not, it tells you your
    // Selection and price. For inserting coins, it adds
    // To money. Can also choose to refund money if no
    // Beverage is appealing enough for choice. Last,
    // There is an option to restock the machine, if
    // You ran completely out of beverages or just feel
    // Like hitting another button
    public void userChoice(){
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 0) {
            if (money >= slot[choice][0].getPrice()){
                dispense(choice);
            }else {
                display = " Coke $1.25                ";
            }
        } else if (choice == 1) {
            if (money >= slot[choice][0].getPrice()){
                dispense(choice);
            } else {
                display = " Dr Pepper $1.25           ";
            }
        } else if (choice == 2) {
            if (money >= slot[choice][0].getPrice()){
                dispense(choice);
            } else {
                display = " Sprite $1.25              ";
            }
        } else if (choice == 3) {
            if (money >= slot[choice][0].getPrice()){
                dispense(choice);
            } else {
                display = " Mellow Yellow $1.25       ";
            }
        } else if (choice == 4) {
            double amount = input.nextFloat();
            if (amount % 5 == 0){
                insertMoney(amount);
                display = " $" + df2.format(money / 100) + "                     ";
            }
        } else if (choice == 5 && money > 0) {
            emptyChange();
            display = " $" + df2.format(money) + "                        ";
        } else if (choice == 6){
            loadSoda();
            display = " BEVERAGES RESTOCKED       ";
        }
    }
    
    // Checks if the beverage choice is in stock,
    // Calls removeStock, checks to see which beverage
    // Is chosen and prints a nice message, then calls
    // emptyChange to reset money amount so they can't
    // Make unlimited purchases
    public void dispense(int choice){
        if(slot[choice][0].getStock() == true){
            removeStock(choice);
            if(choice == 0){
                display = " VEND, COKE BELOW          ";
            } else if(choice == 1){
                display = " VEND, DR PEPPER BELOW     ";
            } else if(choice == 2){
                display = " VEND, SPRITE BELOW        ";
            } else if(choice == 3){
                display = " VEND, MELLOW YELLOW BELOW ";
            }
            emptyChange();
            
        } else {
            display = " OUT OF STOCK              ";
        }
    }

    // Sets the inStock value to false for the beverage of choice, if purchased
    public void removeStock(int choice){
        int count = 0;
            for(int j = 0; j < slot[choice].length; j++){
                if(slot[choice][j].getStock() == true){
                    count++;
                }
            }
        slot[choice][count - 1].setStock(false);
    }
    
    // Increases money
    public double insertMoney(double amount){
        money += amount;
        return money;
    }
    
    // A fun ASCII graphic to show the options and results of the userInput
    public String getMessage(){
        message = " ---------------------------------------------------------------------------------------------------------------------\n"
                + "|   _________     __________     __________     __________   |  ___________________________            _              |\n"
                + "|  /         \\   /          \\   /          \\   /          \\  | |"+display+"|          |4| Insert Coin |\n"
                + "| |           | |            | |            | |            | |  ---------------------------           \\_/             |\n"
                + "| |           | |            | |            | |            | |   ___            ___                   ___             |\n"
                + "| |           | |            | |            | |            | |  /   \\          /   \\                 /   \\            |\n"
                + "| | Coca-Cola | | Dr Pepper  | |   Sprite   | |   Mellow   | | |  0  | Coke   |  1  | Dr Pepper     |  5  | Refund    |\n"
                + "| |           | |            | |            | |   Yellow   | |  \\___/          \\___/                 \\___/            |\n"
                + "| |           | |            | |            | |            | |   ___            ___                   ___             |\n"
                + "| |           | |            | |            | |            | |  /   \\          /   \\                 /   \\            |\n"
                + "| |           | |            | |            | |            | | |  2  | Sprite |  3  | Mellow Yellow |  6  | Restock   |\n"
                + "|  \\_________/   \\__________/   \\__________/   \\__________/  |  \\___/          \\___/                 \\___/            |\n"
                + " ---------------------------------------------------------------------------------------------------------------------\n";
        return message;
    }
    
    // Loads each row with a different flavor beverage, assigns a price and
    // A boolean value for if it is in stock
    public void loadSoda(){
        for(int i =0; i < 4; i++){
            for(int j = 0; j < 20; j++){
                if(i==0)slot[i][j] = new Soda("Coke",125,true);
                if(i==1)slot[i][j] = new Soda("Dr. Pepper",125,true);
                if(i==2)slot[i][j] = new Soda("Sprite",125,true);
                if(i==3)slot[i][j] = new Soda("Mellow Yellow",125,true);
            }
        }
    }
    
    // Resets money variable to 0
    public double emptyChange(){
        money = 0;
        return money;
    }
    
    // Reports back brand and price the 4 buttons
    public Soda button1(){
        return slot[0][0];
    }
    
    public Soda button2(){
        return slot[1][0];
    }
    
    public Soda button3(){
        return slot[2][0];
    }
    
    public Soda button4(){
        return slot[3][0];
    }

}
