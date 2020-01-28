package src.com.javaguru.shoppinglist;


import java.math.BigDecimal;

public class ShoppingValidation {

    public String name;
    public BigDecimal price;
    public String category;
    public BigDecimal percent;

    public ShoppingValidation(String name, BigDecimal price, String category, BigDecimal percent) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.percent = percent;

    }

    public int productValidationName(String name) {


        if (name.length() < 3 | name.length() > 32) {
            int i = 1;
            return i;
        } else {
            int i = 2;
            return i;
        }

    }

    public int productValidationPrice(BigDecimal price) {
        BigDecimal x = new BigDecimal("0");
        int k=price.compareTo(x);
        if (k == -1) {
            int i = 1;
            return i;
        } else {
            int i = 2;
            return i;
        }
    }

    public int productValidationPercent(BigDecimal percent) {
        BigDecimal x = new BigDecimal("1");
        int k=percent.compareTo(x);
        if (k == 1 ) {
            int i = 1;
            return i;
        } else {
            int i = 2;
            return i;
        }
    }

}
