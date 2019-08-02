package com.merc.bazinga.application.shopify.dao;

import java.util.List;

import com.merc.bazinga.application.shopify.model.orders;
import org.springframework.data.repository.CrudRepository;

public interface orderdao extends CrudRepository<orders, Integer>{

  List<orders> findByDate(String Date);
}
