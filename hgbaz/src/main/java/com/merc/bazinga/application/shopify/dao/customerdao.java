package com.merc.bazinga.application.shopify.dao;

import java.util.List;

import com.merc.bazinga.application.shopify.model.customers;
import org.springframework.data.repository.CrudRepository;

public interface customerdao extends CrudRepository<customers, Integer> {
  List<customers> findByCustomerid(Integer customer_id);

}
