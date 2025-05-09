package HospitalManagement.HospitalManagement.Repo;

import HospitalManagement.HospitalManagement.Entities.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalsRepo extends JpaRepository<Hospitals,Long> {
}
