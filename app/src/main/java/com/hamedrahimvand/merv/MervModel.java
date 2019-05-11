package com.hamedrahimvand.merv;

import java.util.List;

public class MervModel {

    private int id;
    private String name;
    private boolean isChild;
    private boolean hasChild;
    private boolean isOpen;
    private int rotation;
    private List<MervModel> childList;


    public MervModel(int id, String name, boolean isChild, boolean hasChild, boolean isOpen) {
        this.id = id;
        this.name = name;
        this.isChild = isChild;
        this.hasChild = hasChild;
        this.isOpen = isOpen;
    }

    public MervModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public List<MervModel> getChildList() {
        return childList;
    }

    public void setChildList(List<MervModel> childList) {
        this.childList = childList;
    }

}
