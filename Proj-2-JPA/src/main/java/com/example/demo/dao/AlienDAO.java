package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

//public interface AlienDAO extends CrudRepository<Alien,Integer>{
public interface AlienDAO extends JpaRepository<Alien,Integer>{

}
