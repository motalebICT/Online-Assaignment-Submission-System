package com.springwebmvc.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by motaleb on 7/18/17.
 */
@Entity
public class Folders {
    @Id
    private String folderName;
    private User createdBy;

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Folders{" +
                "folderName='" + folderName + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
