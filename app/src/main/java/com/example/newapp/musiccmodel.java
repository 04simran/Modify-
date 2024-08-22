package com.example.newapp;

public class musiccmodel {
    private String songName;
    private String artist;
    private  int imgurl;
    private int songs;

    public musiccmodel(String songName, String artist, int songs,int imgurl) {
        this.songName = songName;
        this.artist = artist;
        this.songs = songs;
        this.imgurl = imgurl;
    }

    public int getImgurl() {
        return imgurl;
    }

    public void setImgurl(int imgurl) {
        this.imgurl = imgurl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongs() {
        return songs;
    }

    public void setSongs(int songs) {
        this.songs = songs;
    }
}
