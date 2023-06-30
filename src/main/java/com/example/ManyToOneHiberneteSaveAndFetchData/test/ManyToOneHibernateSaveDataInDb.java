package com.example.ManyToOneHiberneteSaveAndFetchData.test;

import com.example.ManyToOneHiberneteSaveAndFetchData.domain.AllStateInIndia;
import com.example.ManyToOneHiberneteSaveAndFetchData.domain.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManyToOneHibernateSaveDataInDb {
    public static void main (String[]args ){
        StandardServiceRegistry ssrr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssrr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

        Country country = new Country();
        country.setCountryName("India");
        country.setPopulation("14cr");


        Country country1 = new Country();
        country1.setCountryName("USA");
        country1.setPopulation("8cr");

        Country country2 = new Country();
        country2.setCountryName("japan");
        country2.setPopulation("5cr");

        AllStateInIndia allStateInIndia = new AllStateInIndia();
        allStateInIndia.setStateName("MH");
        allStateInIndia.setStatePopulation("2 lakh");

        country.setAllStateInIndia(allStateInIndia);
        country1.setAllStateInIndia(allStateInIndia);
        country2.setAllStateInIndia(allStateInIndia);

        session.persist(country);
        session.persist(country1);
        session.persist(country2);

        txs.commit();
        session.close();
        System.out.println("data has been save successfully save in db");


    }
}
