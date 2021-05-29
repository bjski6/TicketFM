//package myapp.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity
//public class InstallationType {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//
//    //nazwa systemu, HVAC/ Electrical and lighting installation/ Fire protection system
//    // / Water and sewage installations/ Buildings/ External areas/ General
//    private String name;
//
//    @OneToMany (mappedBy = "installationTypeInspection")
//    private List <Inspection> installationTypeInspectionList;
//
//    @OneToMany (mappedBy = "installationTypeTickets")
//    private List <Tickets> installationTypeTicketsList;
//
////    @OneToMany (mappedBy = "installationType")
////    private List <Installation> installationTypeList;
//
//
//}
