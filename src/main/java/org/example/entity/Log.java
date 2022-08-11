package org.example.entity;


import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "tb_logs")
public class Log implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long studentId;

    @UpdateTimestamp
    private OffsetDateTime offsetDateTime;
    
    private String message;
}
