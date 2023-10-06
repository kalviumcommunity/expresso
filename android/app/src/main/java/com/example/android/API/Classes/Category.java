package com.example.android.API.Classes;

public class Category {
    long categoryId;
    String category;

    public Category(long categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }
}
