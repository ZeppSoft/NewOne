package Utils;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
        @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
        private String modelName;
    private String hullType;
    private String color;

    public String getIsHatch() {
        return isHatch;
    }

    public void setIsHatch(String isHatch) {
        this.isHatch = isHatch;
    }

    private String isHatch;


    public String getHullType() {
        return hullType;
    }

    public void setHullType(String hullType) {
        this.hullType = hullType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

