package hello.springmvc.project.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter// 게터, 세터
public class Item {
    private Long id;
    private String itemName;
    private Integer price; // NULL 일 수 없다. 0원이라도 가격이 있어야 한다.
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
