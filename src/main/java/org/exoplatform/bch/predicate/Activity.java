package org.exoplatform.bch.predicate;

import java.util.Date;

/**
 * Created by bdechateauvieux on 4/5/15.
 */
public class Activity {
    private final String title;
    private final Date creationDate;
    private final int nbComments;
    private final int nbLikes;

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
