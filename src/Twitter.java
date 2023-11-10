/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXAM;

/**
 *
 * @author Lourdes
 */
public class Twitter extends SocialClass {
    public Twitter(String username) {
        super(username);
    }

    @Override
    public void timeline() {
        System.out.println("Timeline for Twitter user " + username + ":");
        for (String post : posts) {
            System.out.println(post);
        }
    }
}

