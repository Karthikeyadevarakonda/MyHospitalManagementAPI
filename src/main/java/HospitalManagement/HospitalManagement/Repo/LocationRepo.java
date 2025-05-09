package HospitalManagement.HospitalManagement.Repo;

import HospitalManagement.HospitalManagement.Entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Locations,Long> {
}
