package com.maracujasoftware.shoppinglistplusplus.model;

import java.util.HashMap;

/**
 * Defines the data structure for FireUser objects.
 */
public class FireUser {
    private String name;
    private String email;
    private HashMap<String, Object> timestampJoined;
   // private boolean hasLoggedInWithPassword;


    /**
     * Required public constructor
     */
    public FireUser() {
    }

    /**
     * Use this constructor to create new FireUser.
     * Takes user name, email and timestampJoined as params
     *
     * @param name
     * @param email
     * @param timestampJoined
     */
    public FireUser(String name, String email, HashMap<String, Object> timestampJoined) {
        this.name = name;
        this.email = email;
        this.timestampJoined = timestampJoined;
        //this.hasLoggedInWithPassword = false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public HashMap<String, Object> getTimestampJoined() {
        return timestampJoined;
    }

  /*  public boolean isHasLoggedInWithPassword() {
        return hasLoggedInWithPassword;
    }*/
}
