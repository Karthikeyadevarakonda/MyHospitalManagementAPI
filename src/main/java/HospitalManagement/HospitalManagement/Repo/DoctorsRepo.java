package HospitalManagement.HospitalManagement.Repo;

import HospitalManagement.HospitalManagement.Entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepo extends JpaRepository<Doctors,Long> {
}
