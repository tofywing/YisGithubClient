package com.peter.android.yisgitclient.model;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity
public class LocalUser {


    private String login;
    private String name;
    private String avatarUrl;
    private Integer followers;
    private Integer following;

    public LocalUser() {

    }

    public LocalUser(@NonNull String login) {
        this.login = login;
    }

    public LocalUser(@NonNull String login, String name, String avatarUrl, Integer followers,
                     Integer following) {
        this.login = login;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.followers = followers;
        this.following = following;
    }

    @NotNull
    public String getLogin() {
        return login;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setLogin(@NotNull String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

}