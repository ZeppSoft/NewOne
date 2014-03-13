package Utils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Order{
    private String number;
        @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
        @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

   @OneToMany(mappedBy = "order")
    private Collection<Car> cars;

    public Order() {
        number="000001";
        cars=new ArrayList<Car>();
        }


    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
