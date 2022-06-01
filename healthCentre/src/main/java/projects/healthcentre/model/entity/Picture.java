package projects.healthcentre.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private String pictureUrl;

    public Picture() {
    }

    @Column(name = "picture_url", nullable = false, unique = true)
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
