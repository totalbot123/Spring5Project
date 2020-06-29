package com.Rasadnici.Rasadnici.Item.ItemDAO;

import com.Rasadnici.Rasadnici.Item.ItemData.Item;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}