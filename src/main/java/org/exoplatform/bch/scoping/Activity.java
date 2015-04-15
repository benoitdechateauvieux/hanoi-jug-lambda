package org.exoplatform.bch.scoping;

import java.util.Date;

/**
 * Created by bdechateauvieux on 4/5/15.
 */
public class Activity {
    private String title;
    private Date creationDate;
    private int nbComments;
    private int nbLikes;

    public Activity() {

    }

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getNbComments() {
        return nbComments;
    }

    public int getNbLikes() {
        return nbLikes;
    }

    public Activity(String title, int nbLikes, int nbComments, Date creationDate) {
        this.title = title;
        this.nbLikes = nbLikes;
        this.nbComments = nbComments;
        this.creationDate = creationDate;
    }
}
