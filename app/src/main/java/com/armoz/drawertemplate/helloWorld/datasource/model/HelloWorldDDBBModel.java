package com.armoz.drawertemplate.helloWorld.datasource.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ruben.arana on 23/11/15.
 */
@DatabaseTable(tableName = "helloWorld")
public class HelloWorldDDBBModel {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField
    private String name;
    @DatabaseField
    private String normalizedName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormalizedName() {
        return normalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
    }
}
