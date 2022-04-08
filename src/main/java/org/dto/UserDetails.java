package org.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//Know about GenericGenerator,GenericGenerators

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="Aliens")
public class UserDetails {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;

    /*Now a one to Many mapping with songs
    * This makes foreign key in songs table... That means userDetails became parent table.
    * We will make songs a child...And UserDetails a parent
    * STEP-1: Add the entity userDetails in Songs
    * STEP-2: Add the entity Songs here as a collection. As there will be many songs
    * STEP-3: In step-2, Beside @oneToMany put (mappedBy = the table who will become the parent table)
    * STEP-4: In Songs entity put @manyToOne create @JoinColumns add this: (name = "USERID", referencedColumnName = "userId")...This becomes a foreign key in child table
    * STEP-5: Create multiple songs object
    * STEP-6: Set them userDetails
    * */

    @OneToMany(mappedBy = "userDetails")
    private Collection<Songs> Playlist = new ArrayList<Songs>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Collection<Songs> getPlaylist() {
        return Playlist;
    }

    public void setPlaylist(Collection<Songs> playlist) {
        Playlist = playlist;
    }
}
