package tn.esprit.spring.firstms.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	int id;
	@Column(unique = true)
	String code;
	boolean actif;
	LocalDate createdAt;
	LocalDate updatedAt;
}
