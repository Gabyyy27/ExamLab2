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
import java.util.ArrayList;

public class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;
    protected String username;

    public SocialClass(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }
    
    

    public boolean addFriend(String user) {
        if (!friends.contains(user) && !user.equals(username)) {
            friends.add(user);
            return true;
        }
        return false;
    }

    public void addPost(String msg) {
        posts.add(msg);
    }

    public void timeline() {
        System.out.println("Timeline for " + username + ":");
        for (String post : posts) {
            System.out.println(post);
        }
        System.out.println("Friend Posts:");
        for (String friend : friends) {
            System.out.println("Posts from " + friend + ":");
            // Aquí podrías acceder a los posts de los amigos y mostrarlos
        }
    }

    public void myProfile() {
        System.out.println("Profile for " + username + ":");
        System.out.println("Friends: " + friends);
        System.out.println("Posts: " + posts);
    }
}

