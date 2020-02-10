package com.Canada.androidproficiencyexercise.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Canada {

    @Expose
    @SerializedName("rows")
    private List<RowsEntity> rows;
    @Expose
    @SerializedName("title")
    private String title;

    public List<RowsEntity> getRows() {
        return rows;
    }

    public void setRows(List<RowsEntity> rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class RowsEntity {
        @Expose
        @SerializedName("imageHref")
        private String imagehref;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("title")
        private String title;

        public String getImagehref() {
            return imagehref;
        }

        public void setImagehref(String imagehref) {
            this.imagehref = imagehref;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
