package com.peter.android.yisgitclient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ReleaseAsset implements Parcelable {

   private String id;
   private String name;
   private String label;
   private User uploader;
   @SerializedName("content_type") private String contentType;
   private String state;
   private long size;
   private int downloadCout;
   @SerializedName("created_at") private Date createdAt;
   @SerializedName("updated_at") private Date updatedAt;
   @SerializedName("browser_download_url") private String downloadUrl;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }

   public User getUploader() {
      return uploader;
   }

   public void setUploader(User uploader) {
      this.uploader = uploader;
   }

   public String getContentType() {
      return contentType;
   }

   public void setContentType(String contentType) {
      this.contentType = contentType;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public long getSize() {
      return size;
   }

   public void setSize(long size) {
      this.size = size;
   }

   public int getDownloadCout() {
      return downloadCout;
   }

   public void setDownloadCout(int downloadCout) {
      this.downloadCout = downloadCout;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public Date getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
   }

   public String getDownloadUrl() {
      return downloadUrl;
   }

   public void setDownloadUrl(String downloadUrl) {
      this.downloadUrl = downloadUrl;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id);
      dest.writeString(this.name);
      dest.writeString(this.label);
      dest.writeParcelable(this.uploader, flags);
      dest.writeString(this.contentType);
      dest.writeString(this.state);
      dest.writeLong(this.size);
      dest.writeInt(this.downloadCout);
      dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
      dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
      dest.writeString(this.downloadUrl);
   }

   public ReleaseAsset() {
   }

   protected ReleaseAsset(Parcel in) {
      this.id = in.readString();
      this.name = in.readString();
      this.label = in.readString();
      this.uploader = in.readParcelable(User.class.getClassLoader());
      this.contentType = in.readString();
      this.state = in.readString();
      this.size = in.readLong();
      this.downloadCout = in.readInt();
      long tmpCreatedAt = in.readLong();
      this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
      long tmpUpdatedAt = in.readLong();
      this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
      this.downloadUrl = in.readString();
   }

   public static final Parcelable.Creator<ReleaseAsset> CREATOR = new Parcelable.Creator<ReleaseAsset>() {
      @Override
      public ReleaseAsset createFromParcel(Parcel source) {
         return new ReleaseAsset(source);
      }

      @Override
      public ReleaseAsset[] newArray(int size) {
         return new ReleaseAsset[size];
      }
   };
}
