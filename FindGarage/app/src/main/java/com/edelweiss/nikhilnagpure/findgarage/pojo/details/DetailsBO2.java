package com.edelweiss.nikhilnagpure.findgarage.pojo.details;

import android.support.annotation.NonNull;

import org.json.JSONObject;

public class DetailsBO2 implements IDetails {

    private String id;
    private String name;
    private String parentName;
    private String pid;
    private String masterType;
    private Object pojo;


    public DetailsBO2(String id, String name) {
        this.id = id;
        this.name = name;
        this.parentName = "";
        this.pid = "";
        this.masterType = "";
    }

    public DetailsBO2(String name) {
        this.id = "";
        this.name = name;
        this.parentName = "";
        this.pid = "";
        this.masterType = "";
    }

    public DetailsBO2(String id, String name, String masterType) {
        this.id = id;
        this.name = name;
        this.pid = "";
        this.parentName = "";
        this.masterType = masterType;


    }

    public DetailsBO2(String id, String name, String pid, String parentName) {
        this.id = id;
        this.name = name;
        this.parentName = parentName;
        this.pid = pid;

    }
    public DetailsBO2(String id, String name, String pid, String parentName, String masterType) {
        this.id = id;
        this.name = name;
        this.parentName = parentName;
        this.pid = pid;
        this.masterType = masterType;
    }
    public DetailsBO2(String id, String name, String pid, String parentName, String masterType,Object pojo) {
        this.id = id;
        this.name = name;
        this.parentName = parentName;
        this.pid = pid;
        this.masterType = masterType;
        this.pojo = pojo;
    }



    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {

        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getParentId() {
        return pid;
    }

    @Override
    public void setParentId(String parentId) {
        this.pid = parentId;
    }

    @Override
    public String getParentName() {
        return parentName;
    }

    @Override
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String getType() {
        return masterType;
    }

    @Override
    public void setType(String type) {

        this.masterType = masterType;
    }

    @Override
    public JSONObject toJson() {
        return null;
    }

    @Override
    public String getJsonString() {
        return null;
    }

    @Override
    public void setJsonString(String jsonStr) {

    }

    @Override
    public Object getPojo() {
        return pojo;
    }

    @Override
    public void setPojo(Object jsonStr) {

        this.pojo = jsonStr;
    }


    @Override
    public String toString() {
        return "DetailsBO2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", pid='" + pid + '\'' +
                ", masterType='" + masterType + '\'' +
                ", pojo=" + pojo +
                '}';
    }
}
