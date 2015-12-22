/*
 * package com.att.domain;
 * 
 * import java.io.Serializable; import java.util.Date; import java.util.Set;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.FetchType; import
 * javax.persistence.GeneratedValue; import javax.persistence.Id; import
 * javax.persistence.OneToMany; import javax.persistence.OneToOne; import
 * javax.persistence.Table; import javax.validation.constraints.NotNull; import
 * javax.validation.constraints.Past; import javax.validation.constraints.Size;
 * 
 * import org.hibernate.annotations.GenericGenerator;
 * 
 * @Entity
 * 
 * @Table(name = "CATTLE") public class Services implements Serializable {
 * 
 * private static final long serialVersionUID = 5978668717067931168L;
 * 
 * @Id
 * 
 * @GeneratedValue(generator = "system-uuid")
 * 
 * @GenericGenerator(name = "system-uuid", strategy = "uuid")
 * 
 * @Column(name = "SERVICE_ID", unique = true) private String id;
 * 
 * @OneToMany(mappedBy = "cattle", fetch = FetchType.LAZY, cascade =
 * CascadeType.ALL) private List<Health> health;
 * 
 * @OneToOne(mappedBy = "cattle", cascade = CascadeType.ALL) private
 * Reproduction reproduction;
 * 
 * @NotNull
 * 
 * @Size(min = 2, max = 5)
 * 
 * @Column(name = "IDENTITY_NUMBER") private String identityNumber;
 * 
 * @NotNull
 * 
 * @Past
 * 
 * @Column(name = "BIRTH_DATE") private Date birthDate;
 * 
 * @Column(name = "AGE") private String age;
 * 
 * @Column(name = "SEX") private String sex;
 * 
 * @Column(name = "BREED") private String breed;
 * 
 * }
 */