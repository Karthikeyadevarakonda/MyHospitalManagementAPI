package HospitalManagement.HospitalManagement.Controllers;


import HospitalManagement.HospitalManagement.Entities.Doctors;
import HospitalManagement.HospitalManagement.Entities.Hospitals;
import HospitalManagement.HospitalManagement.Entities.Locations;
import HospitalManagement.HospitalManagement.Entities.Specialists;
import HospitalManagement.HospitalManagement.Repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationRepo locationRepo;

    @PostMapping("/add")
    public ResponseEntity<Locations> createLocation(@RequestBody Locations location) {
        // Manually wire relationships
        if (location.getHospitals() != null) {
            for (Hospitals hospital : location.getHospitals()) {
                hospital.setLocation(location); // Set back-reference

                if (hospital.getDoctors() != null) {
                    for (Doctors doctor : hospital.getDoctors()) {
                        doctor.setHospital(hospital); // Set back-reference
                    }
                }

                if (hospital.getSpecialists() != null) {
                    for (Specialists specialist : hospital.getSpecialists()) {
                        specialist.setHospital(hospital); // Set back-reference
                    }
                }
            }
        }

        Locations saved = locationRepo.save(location);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Locations>> displayLocations() {
        List<Locations> locations = locationRepo.findAll();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/id/{locationId}")
    public ResponseEntity<Locations> getLocationById(@PathVariable Long locationId) {
        return locationRepo.findById(locationId).
                map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());

    }

}