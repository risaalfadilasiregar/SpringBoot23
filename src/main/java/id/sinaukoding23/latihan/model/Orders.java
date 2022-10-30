package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Orders extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer orderId;

    @Column
    private Integer orderStatus;

    @Column
    private Date orderDate;

    @Column
    private Date requiredDate;

    @Column
    private Date shippedDate;

}
