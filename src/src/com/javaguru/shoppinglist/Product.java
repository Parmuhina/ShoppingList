package src.com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal percent;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory(){
        return category;
    }

    public String setCategory(String category){
        return this.category=category;
    }

    public BigDecimal getPercent(){
        return percent;
    }

    public BigDecimal setPercent (BigDecimal percent){
        return this.percent=percent;
    }

    public String getText(){
        return text;
    }

    public String setText (String text){
        return this.text=text;
    }


}