package projects.healthcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.healthcentre.model.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
