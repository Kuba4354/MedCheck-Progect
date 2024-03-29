import dao.Impl.HospitalDaoImpl;
import dao.Impl.PatientDaoImpl;
import dataBase.Database;
import enums.Gender;
import generedId.GeneredId;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.Impl.DepartmentServiceImpl;
import service.Impl.DoctorServiceImpl;
import service.Impl.HospitalServiceImpl;
import service.Impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\033[0m";  // сброс цвета
    public static final String RED = "\033[0;31m"; // красный цвет

    public static void main(String[] args) {
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        Scanner scanner = new Scanner(System.in);
        System.out.println(RED + """
                ╔════════════════════════════════════════════════════════════════════════════════════════════╗
                ║  0 ->  Exit                                   13 -> Remove Doctor by ID                    ║
                ║  1 ->  Add Hospital                           14 -> Update Doctor by ID                    ║
                ║  2 ->  Find Hospital by ID                    15 -> Find Doctor by ID                      ║
                ║  3 ->  Get all Hospitals                      16 -> Assign Doctors to Department           ║
                ║  4 ->  Get all Patients from Hospital         17 -> Get all Doctors by Hospital ID         ║
                ║  5 ->  Delete Hospital by ID                  18 -> Get all Doctors by Department ID       ║
                ║  6 ->  Get all Hospitals by address           19 -> Add Patient to Hospital by ID          ║
                ║  7 ->  Add Department to Hospital by ID       20 -> Remove Patient by ID                   ║
                ║  8 ->  Remove Department by ID                21 -> Update Patient by ID                   ║
                ║  9 ->  Update Department by ID                22 -> Add Patients to Hospital by ID         ║
                ║ 10 -> Get all Department by Hospital ID       23 -> Get Patient by ID                      ║
                ║ 11 -> Find Department by name                 24 -> Get Patient by age                     ║
                ║ 12 -> Add Doctor to Hospital by ID            25 -> Sort Patient by age                    ║
                ╚════════════════════════════════════════════════════════════════════════════════════════════╝
                """);

        while (true) {
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    Hospital hospital = new Hospital();
                    hospital.setId(GeneredId.generatorHospitalid());
                    System.out.println("напиши имя болницу");
                    hospital.setHospitalName(new Scanner(System.in).nextLine());
                    System.out.println("напиши адресс болницу");
                    hospital.setAddress(new Scanner(System.in).nextLine());
                    Database.hospitals.add(hospital);
                    System.out.println(hospitalService.addHospital(hospital));
                }
                case 2 -> {
                    System.out.println(" пиши id ");
                    System.out.println(hospitalService.findHospitalById(scanner.nextLong()));
                }
                case 3 -> {
                    System.out.println(hospitalService.getAllHospital());

                }
                case 4 -> {
                    System.out.println("напиши di hospital и получи клиентовь");
                    System.out.println(hospitalService.findHospitalById(scanner.nextLong()));
                }
                case 5 -> {

                    System.out.println("напиши id hospital и удали");
                    System.out.println(hospitalService.deleteHospitalById(scanner.nextLong()));
                }
                case 6 -> {
                    System.out.println("напиши adress hospital");
                    System.out.println(hospitalService.getAllHospitalByAddress(scanner.nextLine()));
                }
                case 7 -> {
                    Department department = new Department();
                    department.setId(GeneredId.generatorDepartmentid());
                    System.out.println("Напишите id больницы:");
                    Long id = scanner.nextLong();
                    System.out.println("напишите название отдела");
                    String name = scanner.next();
                    department.setDepartmentName(name);
                    System.out.println(departmentService.add(id, department));
                }
                case 8 -> {

                    System.out.println("напиши  id удалению");
                    Long id = scanner.nextLong();
                    doctorService.removeById(id);

                }
                case 9 -> {
                    Department department = new Department();
                    System.out.println("Update department");
                    Long id = scanner.nextLong();
                    department.setId(GeneredId.generatorDepartmentid());
                    System.out.println("Write new department name: ");
                    String departmentName = scanner.nextLine();
                    department.setDepartmentName(departmentName);
                    System.out.println("department name:");
                    department.setId(id);
                }
                case 10 -> {

                    System.out.println("Write id Hospital");
                    Long newId = scanner.nextLong();
                    System.out.println(departmentService.getAllDepartmentByHospital(newId));
                }
                case 11 -> {

                    System.out.println("write Hospital name: ");
                    String newName = scanner.next();
                    System.out.println(departmentService.findDepartmentByName(newName));

                }
                case 12 -> {
                    Doctor newDoctor = new Doctor();
                    newDoctor.setId(GeneredId.generatorDoctor());
                    System.out.println("Write hospital id:  ");
                    Long id = scanner.nextLong();
                    System.out.println("Enter doctor first name: ");
                    String name = scanner.next();
                    newDoctor.setFirstName(name);
                    System.out.println("Enter doctor last name: ");
                    String lname = scanner.next();
                    newDoctor.setLastName(lname);
                    System.out.println("Enter gender:(MALE/FEMALE)");
                    Gender gender = Gender.valueOf(scanner.next());
                    newDoctor.setGender(gender);
                    System.out.println("Enter experence year: ");
                    int year = scanner.nextInt();
                    newDoctor.setExperienceYear(year);
                    System.out.println(doctorService.add(id, newDoctor));
                }
                case 13 -> {
                    System.out.println("Delete doctor id");
                    Long id = scanner.nextLong();
                    doctorService.removeById(id);
                }
                case 14 -> {
                    Doctor doctor = new Doctor();
                    System.out.println("Update doctor");
                    Long id = scanner.nextLong();
                    doctor.setId(GeneredId.generatorDoctor());
                    System.out.println("Write new doctor");
                    String doctor1 = scanner.next();
                    doctor.setFirstName(doctor1);
                    System.out.println("Doctor name");
                    System.out.println(doctorService.add(id, doctor));
                }
                case 15 -> {
                    System.out.println("write id doctor");
                    Long id = scanner.nextLong();
                    System.out.println(doctorService.findDoctorById(id));

                }
                case 16 -> {
                    System.out.println("write department id");
                    Long id = scanner.nextLong();
                    System.out.println("write doctor id");
                    Long did = scanner.nextLong();
                    System.out.println(doctorService.assignDoctorToDepartment(id, Collections.singletonList(did)));

                }
                case 17 -> {
                    System.out.println("Write id hospital");
                    Long id = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(id));
                }
                case 18 -> {
                    System.out.println("write department id");
                    Long id = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(id));

                }
                case 19 -> {
                    Patient newPatient = new Patient();
                    newPatient.setId(GeneredId.patientID);
                    System.out.println("write hospital id");
                    Long id = scanner.nextLong();
                    System.out.println("Enter patient first name");
                    String firstName = scanner.next();
                    newPatient.setFirstName(firstName);
                    System.out.println("enter patient last name ");
                    String lastName = scanner.next();
                    newPatient.setLastName(lastName);
                    System.out.println("Write patient age: ");
                    int age = scanner.nextInt();
                    newPatient.setAge(age);
                    System.out.println("Write patient gender FEMALE/MALE");
                    Gender gender = Gender.valueOf(scanner.next());
                    newPatient.setGender(gender);
                    System.out.println(patientService.add(id, newPatient));

                }
                case 20 -> {
                    System.out.println("Enter the id to delete a patient: ");
                    Long id = scanner.nextLong();
                    patientService.removeById(id);
                }
                case 21 -> {
                    Patient patient = new Patient();
                    System.out.println("Write the id to update the patient:");
                    Long id = scanner.nextLong();
                    System.out.println("Write new patient firsName");
                    String ferstName = scanner.next();
                    patient.setFirstName(ferstName);
                    System.out.println("Write new patient last name");
                    String lastnaem = scanner.next();
                    patient.setLastName(lastnaem);
                    System.out.println("write new patient age");
                    int age = scanner.nextInt();
                    patient.setAge(age);
                    System.out.println("write new patient gender FEMALE/MAlE");
                    Gender gender = Gender.valueOf(scanner.next());
                    patient.setGender(gender);
                    System.out.println(patientService.upDateById(id, patient));
                }
                case 22 -> {
                    Patient newPatient1 = new Patient();
                    Patient newPatient2 = new Patient();
                    List<Patient> list = new ArrayList<>(List.of(newPatient1, newPatient2));
                    System.out.println("write hospital id");
                    Long newId = scanner.nextLong();
                    newPatient1.setId(GeneredId.generatorPatientid());
                    System.out.println("write patient first name");
                    String firstName1 = scanner.next();
                    newPatient1.setFirstName(firstName1);
                    System.out.println("write last name: ");
                    String lastName1 = scanner.next();
                    newPatient1.setLastName(lastName1);
                    System.out.println("write patient age: ");
                    int age = scanner.nextInt();
                    newPatient1.setAge(age);
                    System.out.println("write patient gender FEMALE/MALE");
                    Gender gender = Gender.valueOf(scanner.next());
                    newPatient1.setGender(gender);


                    System.out.println("write hospital id");

                    newPatient2.setId(GeneredId.generatorPatientid());
                    System.out.println("write patient first name");
                    String firstName2 = scanner.next();
                    newPatient2.setFirstName(firstName2);
                    System.out.println("write last name: ");
                    String lastName2 = scanner.next();
                    newPatient2.setLastName(lastName2);
                    System.out.println("write patient age: ");
                    int age1 = scanner.nextInt();
                    newPatient2.setAge(age1);
                    System.out.println("write patient gender FEMALE/MALE");
                    Gender gender1 = Gender.valueOf(scanner.next());
                    newPatient2.setGender(gender1);
                    System.out.println(patientService.addPatientsToHospital(newId, list));

                }
                case 23 -> {
                    System.out.println("Write id patient");
                    Long id = scanner.nextLong();
                    System.out.println(patientService.getPatientById(id));

                }
                case 24 -> {
                    System.out.println("Write the patient's age:");
                    int age = scanner.nextInt();
                    System.out.println(patientService.getPatientByAge(age));

                }
                case 25 -> {
                    System.out.println("write patient sort age (asc/desc");
                    String ascOrDesc = scanner.next();
                    System.out.println(patientService.sortPatientsByAge(ascOrDesc));


                }
            }
        }
    }
}


//                case 19 -> {
//
//                    PatientDaoImpl patientDao = new PatientDaoImpl();
//                    ;
//                    Patient patient = new Patient();
//                    Hospital hospital = new Hospital();
//                    try {
//                        patient.setId(GeneredId.generatorPatientid());
//                        System.out.println("FirstName jazynyz: ");
//                        patient.setFirstName(new Scanner(System.in).nextLine());
//                        System.out.println("LastName jazynyz: ");
//                        patient.setLastName(new Scanner(System.in).nextLine());
//                        System.out.println("Age jazynyz: ");
//                        patient.setAge(new Scanner(System.in).nextInt());
//                        System.out.println("Gender jazynyz: ");
//                        if (new Scanner(System.in).nextLine().equalsIgnoreCase("M")) {
//                            patient.setGender(Gender.MALE);
//                        } else if (new Scanner(System.in).nextLine().equalsIgnoreCase("F")) {
//                            patient.setGender(Gender.FEMALE);
////                            Database.hospitals.add(patient.getId())
//                            patientService.addPatientsToHospital(patient.getId(), (List<Patient>) patient);
//                            throw new Exception("Komandany tuura emes terdiniz!!!");
//
//                        }
//
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }

