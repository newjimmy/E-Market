package com.market.models;

public class Category {
    private int category_id;
    private String body_type;
    private String colour;
    private int engine_capacity;
    private int engine_volume;
    private int max_speed;

    public Category(int category_id, String body_type, String colour, int engine_capacity, int engine_volume, int max_speed) {
        this.category_id = category_id;
        this.body_type = body_type;
        this.colour = colour;
        this.engine_capacity = engine_capacity;
        this.engine_volume = engine_volume;
        this.max_speed = max_speed;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getEngine_capacity() {
        return engine_capacity;
    }

    public void setEngine_capacity(int engine_capacity) {
        this.engine_capacity = engine_capacity;
    }

    public int getEngine_volume() {
        return engine_volume;
    }

    public void setEngine_volume(int engine_volume) {
        this.engine_volume = engine_volume;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }
}
