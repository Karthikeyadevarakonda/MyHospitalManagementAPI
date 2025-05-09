package HospitalManagement.HospitalManagement.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "hospitals")
public class Hospitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long hospitalId;

    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;

    @Column(name = "hospital_description")
    private String hospitalDescription;

    @Column(nullable = true)
    private String hospital_image;

    @Column(name = "is_open", nullable = false)
    private Boolean isOpen;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Doctors> doctors;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Specialists> specialists;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @JsonBackReference
    private Locations location;

}
