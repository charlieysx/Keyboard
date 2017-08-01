package com.codebear.demo.bean;

/**
 * description:
 * <p>
 * Created by CodeBear on 2017/7/29.
 */

public class MainButton {
    private int id;
    private String text;

    public MainButton(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
