/**
 * Created by out-spiridonov-es on 07.12.2017.
 */
abstract class Present {
    private String name;
    private Double weght;
    private Double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeght(Double weght) {
        this.weght = weght;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getWeght() {
        return weght;
    }

    public Double getPrice() {
        return price;
    }

    public void call(){
        System.out.print("Present");
    }
}

class Chokolate extends Present{

    Chokolate(){
        setName("Lindt");
        setPrice((double)99);
        setWeght((double)100);
    }
    Chokolate(String n,Double w,Double p){
        setName(n);
        setPrice(w);
        setWeght(p);
    }

    @Override
    public void call() {
        System.out.print("Chokolate");
    }
}

class Candy extends Present{

    Candy(){
        setName("Karakum");
        setPrice((double)199);
        setWeght((double)400);
    }
    Candy(String n,Double w,Double p){
        setName(n);
        setPrice(w);
        setWeght(p);
    }

    @Override
    public void call() {
        System.out.print("Candy");
    }
}

class Fruit extends Present{
    private String kind;

    Fruit(){
        setName("Antonovka");
        setPrice((double)78);
        setWeght((double)200);
        kind = "Apple";
    }
    Fruit(String n,String n1,Double w,Double p){
        setName(n1);
        setPrice(w);
        setWeght(p);
    }


    @Override
    public void call() {
        System.out.print("Apple");
    }
}

class Lemonad extends Present{

    Lemonad(){
        setName("Baykal");
        setPrice((double)89);
        setWeght((double)500);
    }
    Lemonad(String n,Double w,Double p){
        setName(n);
        setPrice(w);
        setWeght(p);
    }

    @Override
    public void call() {
        System.out.print("Lemonad");
    }
}


public class Podarki {
    public static void main(String args[]){
        Chokolate choko1 = new Chokolate();
        Chokolate choko2 = new Chokolate("St.Pet",(double)200,(double)150);
        Candy candy1 = new Candy();
        Fruit fruit1 = new Fruit();
        Fruit fruit2 = new Fruit("Apple","Simerenko",(double)100,(double) 50);
        Fruit fruit3 = new Fruit("miniApple","Ranetki",(double) 300,(double) 150);
        Fruit fruit4 = new Fruit("Grusha","Dushes",(double) 300,(double) 150);
        Lemonad lemonad1 = new Lemonad();
        Lemonad lemonad2 = new Lemonad("Tarhun",(double) 85,(double) 450);
        Present [] nabor = {choko1,choko2,candy1,fruit1,fruit2,fruit3,fruit4,lemonad1,lemonad2};
        System.out.println("--------Подарок--------");
        double price=(double) 0;
        double weitht=(double) 0;
        for (Present x: nabor) {
            System.out.println(x.getName() + " " + x.getWeght() + " " + x.getPrice());
            weitht=weitht+x.getWeght();
            price=price+x.getPrice();
        }
        System.out.print("--------ИТОГО--------\nВес подарка: " + weitht + "\nЦена подарка: " + price);
    }
}
