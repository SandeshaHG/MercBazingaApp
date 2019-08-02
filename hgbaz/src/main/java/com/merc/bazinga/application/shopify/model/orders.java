package com.merc.bazinga.application.shopify.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "mercorders")
public class orders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "order_id")
  private String order_id;

  @Column(name = "date")
  private String date;

  @Column(name = "customer")
  private String customer;

  @Column(name = "payment")
  private String payment;
  @Column(name = "fulfillment")
  private String fulfillment;
  @Column(name = "total")
  private String total;

  public orders(String order_id, String date, String customer, String payment, String fulfillment, String total) {
    this.order_id = order_id;
    this.date = date;
    this.customer = customer;
    this.payment = payment;
    this.fulfillment = fulfillment;
    this.total = total;
  }

  public orders() {
  }
}
