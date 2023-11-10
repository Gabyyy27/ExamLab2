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

public class Facebook extends SocialClass implements Commentable {
    private ArrayList<Comment> comments;

    public Facebook(String username) {
        super(username);
        this.comments = new ArrayList<>();
    }

    public boolean addComment(Comment comment) {
        if (comment.getPostid() < 0 || comment.getPostid() >= posts.size()) {
            // postId no válido
            return false;
        }

        comments.add(comment);
        return true;
    }

    @Override
    public void timeline() {
        System.out.println("Timeline for Facebook user " + username + ":");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println("POST " + (i + 1) + ":");
            System.out.println(posts.get(i));

            // Mostrar comentarios asociados al post
            System.out.println("Comments:");
            for (Comment comment : comments) {
                if (comment.getPostid() == i) {
                    comment.print();
                }
            }
            System.out.println();
        }
    }
}
