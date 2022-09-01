package com.peter.android.yisgitclient.network;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Branch implements Parcelable {

    private String name;
    @SerializedName("zipball_url") private String zipballUrl;
    @SerializedName("tarball_url") private String tarballUrl;

    private boolean isBranch = true;

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipballUrl() {
        return zipballUrl;
    }

    public void setZipballUrl(String zipballUrl) {
        this.zipballUrl = zipballUrl;
    }

    public String getTarballUrl() {
        return tarballUrl;
    }

    public void setTarballUrl(String tarballUrl) {
        this.tarballUrl = tarballUrl;
    }

    public boolean isBranch() {
        return isBranch;
    }

    public void setBranch(boolean branch) {
        isBranch = branch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.zipballUrl);
        dest.writeString(this.tarballUrl);
        dest.writeByte(this.isBranch ? (byte) 1 : (byte) 0);
    }

    protected Branch(Parcel in) {
        this.name = in.readString();
        this.zipballUrl = in.readString();
        this.tarballUrl = in.readString();
        this.isBranch = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Branch> CREATOR = new Parcelable.Creator<Branch>() {
        @Override
        public Branch createFromParcel(Parcel source) {
            return new Branch(source);
        }

        @Override
        public Branch[] newArray(int size) {
            return new Branch[size];
        }
    };
}
