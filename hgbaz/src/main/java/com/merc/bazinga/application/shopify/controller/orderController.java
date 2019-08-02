package com.merc.bazinga.application.shopify.controller;
import java.util.List;


import com.merc.bazinga.application.shopify.dao.customerdao;
import com.merc.bazinga.application.shopify.dao.orderdao;
import com.merc.bazinga.application.shopify.model.customers;
import com.merc.bazinga.application.shopify.model.orders;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class orderController {
  @Autowired
  private orderdao dao;
  @Autowired
  private customerdao cdao;

  @PostMapping("/create")
  public String create(@RequestBody String json) {
    JSONObject jsonObj=new JSONObject(json);
    String order_id=jsonObj.getString("name");
    String date=jsonObj.getString("created_at");
    date=date.substring(0,10);
    String payment=jsonObj.getString("financial_status");
    JSONObject jsonobjcustomer=jsonObj.getJSONObject("customer");
    String customer=jsonobjcustomer.getString("first_name")+" "+jsonobjcustomer.getString("last_name");
    String fulfillment=jsonObj.optString("fulfillment_status","NULL");
    if(fulfillment=="NULL")
    {
      fulfillment="unfulfilled";
    }
    String total=jsonObj.getString("total_price");

    dao.save(new orders(order_id, date,  customer,  payment,  fulfillment,  total));

    Integer customer_id=jsonobjcustomer.getInt("id");
    String email=jsonobjcustomer.getString("email");
    String firstname=jsonobjcustomer.getString("first_name");
    String lastname=jsonobjcustomer.getString("last_name");
    String phone=jsonObj.optString("phone","");
    JSONObject jsonaddress=jsonobjcustomer.getJSONObject("default_address");
    String city=jsonaddress.getString("city");
    String country=jsonaddress.getString("country");
    List<customers> customerslist=cdao.findByCustomerid(customer_id);
    if(customerslist.isEmpty())
    {
      cdao.save(new customers(customer_id,  email,  firstname,  lastname,  phone,  city,  country));
    }
    return "done";
  }

  @RequestMapping(value="/update",method = RequestMethod.PATCH)
  public customers update(@RequestBody customers cust)
  {
    customers foundcustomer=cdao.findOne(cust.getId());
    foundcustomer.setCustomerid(cust.getCustomerid());
    foundcustomer.setEmail(cust.getEmail());
    foundcustomer.setFirstname(cust.getFirstname());
    foundcustomer.setCity(cust.getCity());
    foundcustomer.setCountry(cust.getCountry());
    foundcustomer.setLastname(cust.getLastname());
    foundcustomer.setPhone(cust.getPhone());
    cdao.save(foundcustomer);
    return foundcustomer;
  }

  @GetMapping("/getOrders")
  public List<orders> getOrders() {
    return (List<orders>) dao.findAll();
  }
  @GetMapping("/getCustomers")
  public List<customers> getCustomers() {
    return (List<customers>) cdao.findAll();
  }


}
