package com.peter.android.yisgitclient.model;

import org.jetbrains.annotations.NotNull;

import androidx.room.Entity;

@Entity
public class TraceUser {

   private String login;
   private String name;
   private String avatarUrl;
   private Integer followers;
   private Integer following;
   private java.util.Date startTime;
   private java.util.Date latestTime;
   private Integer traceNum;

   public TraceUser() {
   }

   public TraceUser(String login) {
      this.login = login;
   }

   public TraceUser(String login, String name, String avatarUrl, Integer followers, Integer following, java.util.Date startTime, java.util.Date latestTime, Integer traceNum) {
      this.login = login;
      this.name = name;
      this.avatarUrl = avatarUrl;
      this.followers = followers;
      this.following = following;
      this.startTime = startTime;
      this.latestTime = latestTime;
      this.traceNum = traceNum;
   }

   @NotNull
   public String getLogin() {
      return login;
   }

   /** Not-null value; ensure this value is available before it is saved to the database. */
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

   public java.util.Date getStartTime() {
      return startTime;
   }

   public void setStartTime(java.util.Date startTime) {
      this.startTime = startTime;
   }

   public java.util.Date getLatestTime() {
      return latestTime;
   }

   public void setLatestTime(java.util.Date latestTime) {
      this.latestTime = latestTime;
   }

   public Integer getTraceNum() {
      return traceNum;
   }

   public void setTraceNum(Integer traceNum) {
      this.traceNum = traceNum;
   }

}
