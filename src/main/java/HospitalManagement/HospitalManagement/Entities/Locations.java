package HospitalManagement.HospitalManagement.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Hospitals> hospitals;
}
