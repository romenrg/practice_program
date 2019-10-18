package beverages;

public abstract class BeverageDecorator {
    Beverage rawBeverage;
    public  BeverageDecorator(Beverage beverage) {
        rawBeverage = beverage;
    }
}
