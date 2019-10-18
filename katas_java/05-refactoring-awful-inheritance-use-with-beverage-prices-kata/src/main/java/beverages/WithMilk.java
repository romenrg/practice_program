package beverages;

public class WithMilk extends BeverageDecorator implements Beverage {
    public WithMilk(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double price() {
        return rawBeverage.price() + 0.10;
    }
}
