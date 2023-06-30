package com.example.ManyToOneHiberneteSaveAndFetchData.test;

import com.example.ManyToOneHiberneteSaveAndFetchData.domain.AllStateInIndia;
import com.example.ManyToOneHiberneteSaveAndFetchData.domain.Country;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class ManyToOneHiberneteFetchDataFromDB {
    public static void main(String[] args) {


    StandardServiceRegistry ssrr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(ssrr).getMetadataBuilder().build();

    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    TypedQuery typedQuery= session.createQuery("From Country country");
    List<Country> list = typedQuery.getResultList();
    Iterator<Country> iterator = list.listIterator();

     while(iterator.hasNext())
    {
        Country country = iterator.next();
        System.out.println(country.getCountryName() + " " + country.getPopulation());
        AllStateInIndia allStateInIndia = country.getAllStateInIndia();
        System.out.println(allStateInIndia.getStateName() + "" + allStateInIndia.getStatePopulation());

    }
        session.close();
        System.out.println("data has been successfully retrieve");
        }

    }
