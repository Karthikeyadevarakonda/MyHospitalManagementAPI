package HospitalManagement.HospitalManagement.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "consultation_fee", precision = 10, scale = 2)
    private BigDecimal consultationFee;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    @Column(name = "doctor_image")
    private String doctorImage;
    
    @Column(name = "rating")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @JsonBackReference
    private Hospitals hospital;

}
