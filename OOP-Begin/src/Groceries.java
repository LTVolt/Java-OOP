
public class Groceries {

    double price;
    String name;
    char nutriScore;
    int quantityInCart;

    Groceries(String name, double price, char nutriScore){
        this.price = price;
        this.name = name;
        this.nutriScore = nutriScore;
    }

    void showInfo(int index){
        System.out.printf("%d. %s: $%.2f each, Nutritional Score: %c\n", index + 1, name, price, nutriScore);
    }

    void displayInCart(){
        System.out.printf("You have %d %s(s).\n", quantityInCart, name);
    }

}
