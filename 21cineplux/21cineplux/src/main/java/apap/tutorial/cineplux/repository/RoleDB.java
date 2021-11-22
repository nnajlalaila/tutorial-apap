package apap.tutorial.cineplux.repository;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDB extends JpaRepository<RoleModel, Long> {
    List<RoleModel> findAll();
}
