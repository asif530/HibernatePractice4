package org.controller;


import org.dto.Songs;
import org.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/*
 * Continuation of hibernate 14
 * Here in place of collection we will use entity
 * Purpose: One to Many relation
 * Parent: UserDetails
 * Child: Songs
 * Did not use Vehicle Class/Entity
 * */

public class HibernateTest {
    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("First User");

        Songs songs = new Songs();
        Songs songs1 = new Songs();
        Songs songs2 = new Songs();


        songs.setsName("Hoist the colours");
        songs.setSource("Pirates of the Seas");

        songs1.setsName("The Willow Maid");
        songs1.setSource("Erutan");

        songs2.setsName("Jolly Sailor Bold");
        songs2.setSource("Pirates of the Seas");

        userDetails.getPlaylist().add(songs);
        userDetails.getPlaylist().add(songs1);
        userDetails.getPlaylist().add(songs2);

        songs.setUserDetails(userDetails);
        songs1.setUserDetails(userDetails);
        songs2.setUserDetails(userDetails);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(userDetails);
        session.save(songs);
        session.save(songs1);
        session.save(songs2);

        session.getTransaction().commit();

        userDetails = (UserDetails)session.get(UserDetails.class,1);
        session.close();
    }
}
