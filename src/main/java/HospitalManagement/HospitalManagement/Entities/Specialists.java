package HospitalManagement.HospitalManagement.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Specialists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialists_id")
    private Long specialistsId;

    @Column(name = "specialists_name", nullable = false)
    private String specialistsName;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @JsonBackReference
    private Hospitals hospital;
}
