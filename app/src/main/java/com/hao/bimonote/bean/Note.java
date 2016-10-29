package com.hao.bimonote.bean;

/**
 * Created by DongHao on 2016/10/27
 * Description:
 */

public class Note {
    private int id;
    private String title;
    private String content;
    private String creat_time;
    private String update_time;
    private String image_url;
    private String video_url;
    private String audio_url;


    public Note(int id, String title, String content, String creat_time, String update_time, String image_url, String video_url, String audio_url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creat_time = creat_time;
        this.update_time = update_time;
        this.image_url = image_url;
        this.video_url = video_url;
        this.audio_url = audio_url;
    }

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creat_time='" + creat_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", image_url='" + image_url + '\'' +
                ", video_url='" + video_url + '\'' +
                ", audio_url='" + audio_url + '\'' +
                '}';
    }
}
