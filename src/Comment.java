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
import java.util.Calendar;

public class Comment {
    private int postid;
    private String author;
    private String content;
    private Calendar date;

    public int getPostid() {
        return postid;
    }

    public Comment(int postid, String author, String content) {
        this.postid = postid;
        this.author = author;
        this.content = content;
        this.date = Calendar.getInstance();
    }

    public void print() {
        System.out.println(author + " - " + date.getTime());
        System.out.println(content + "\n");
    }
}

