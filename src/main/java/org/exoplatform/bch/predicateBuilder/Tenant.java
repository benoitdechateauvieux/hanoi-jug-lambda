package org.exoplatform.bch.predicateBuilder;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class Tenant {
    private int minLikes;

    public static Tenant getByName(String tenantName) {
        return new Tenant();
    }

    public int getMinLikes() {
        return minLikes;
    }

    public void setMinLikes(int minLikes) {
        this.minLikes = minLikes;
    }
}
