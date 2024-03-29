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

import java.util.*;

public class Main {
    public static final String RESET = "\033[0m";  // сброс цвета
    public static final String RED = "\033[0;31m"; // красный цвет

    public static void main(String[] args) {
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        Scanner scanner = new Scanner(System.in);
        while (true) {
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
            System.out.println("""
                    0 ->  Выход                                         13 -> Удалить врача по ID
                    1 ->  Добавить больницу                             14 -> Обновить врача по ID
                    2 ->  Найти больницу по ID                          15 -> Найти врача по ID
                    3 ->  Получить список всех больниц                  16 -> Назначить врачей в отделение
                    4 ->  Получить всех пациентов из больницы           17 -> Получить всех врачей по ID больницы
                    5 ->  Удалить больницу по ID                        18 -> Получить всех врачей по ID отделения
                    6 ->  Получить список всех больниц по адресу        19 -> Добавить пациента в больницу по ID
                    7 ->  Добавить отделение в больницу по ID           20 -> Удалить пациента по ID
                    8 ->  Удалить отделение по ID                       21 -> Обновить информацию о пациенте по ID
                    9 ->  Обновить отделение по ID                      22 -> Добавить пациентов в больницу по ID
                    10 -> Получить список всех отделений по ID больницы 23 -> Получить информацию о пациенте по ID
                    11 -> Найти отделение по названию                   24 -> Получить пациента по возрасту
                    12 -> Добавить врача в больницу по ID               25 -> Сортировать пациентов по возрасту
                    """);
            System.out.print("Введите команду: ");
            try {


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
                        System.out.println(hospitalService.findHospitalById(new Scanner(System.in).nextLong()));
                    }
                    case 3 -> {
                        System.out.println(hospitalService.getAllHospital());

                    }
                    case 4 -> {
                        System.out.println("напиши di hospital и получи клиентовь");
                        System.out.println(hospitalService.findHospitalById(new Scanner(System.in).nextLong()));
                    }
                    case 5 -> {

                        System.out.println("напиши id hospital и удали");
                        System.out.println(hospitalService.deleteHospitalById(new Scanner(System.in).nextLong()));
                    }
                    case 6 -> {
                        System.out.println("напиши adress hospital");
                        String newAddress = new Scanner(System.in).nextLine();
                        System.out.println(hospitalService.getAllHospitalByAddress(newAddress));
                    }
                    case 7 -> {
                        Department department = new Department();
                        department.setId(GeneredId.generatorDepartmentid());
                        System.out.println("Напишите id больницы:");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("напишите название отдела");
                        String name = new Scanner(System.in).nextLine();
                        department.setDepartmentName(name);
                        System.out.println(departmentService.add(id, department));
                    }
                    case 8 -> {

                        System.out.println("напиши  id удалению");
                        Long id = new Scanner(System.in).nextLong();
                        doctorService.removeById(id);

                    }
                    case 9 -> {
                        Department department = new Department();
                        System.out.println("Update department");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Write new department name: ");
                        department.setDepartmentName(new Scanner(System.in).nextLine());
                        departmentService.upDateById(id, department);
                    }
                    case 10 -> {

                        System.out.println("Write id Hospital");
                        Long newId = new Scanner(System.in).nextLong();
                        System.out.println(departmentService.getAllDepartmentByHospital(newId));
                    }
                    case 11 -> {

                        System.out.println("write Hospital name: ");
                        String newName = new Scanner(System.in).nextLine();
                        System.out.println(departmentService.findDepartmentByName(newName));

                    }
                    case 12 -> {
                        Doctor newDoctor = new Doctor();
                        newDoctor.setId(GeneredId.generatorDoctor());
                        System.out.println("Write hospital id:  ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Enter doctor first name: ");
                        String name = new Scanner(System.in).nextLine();
                        newDoctor.setFirstName(name);
                        System.out.println("Enter doctor last name: ");
                        String lname = new Scanner(System.in).nextLine();
                        newDoctor.setLastName(lname);
                        System.out.println("Enter gender:(MALE/FEMALE)");
                        Gender gender = Gender.valueOf(scanner.next());
                        newDoctor.setGender(gender);
                        System.out.println("Enter experence year: ");
                        int year = new Scanner(System.in).nextInt();
                        newDoctor.setExperienceYear(year);
                        System.out.println(doctorService.add(id, newDoctor));
                    }
                    case 13 -> {
                        System.out.println("Delete doctor id");
                        Long id = new Scanner(System.in).nextLong();
                        doctorService.removeById(id);
                    }
                    case 14 -> {
                        Doctor doctor = new Doctor();
                        System.out.println("Update doctor");
                        Long id = new Scanner(System.in).nextLong();
                        doctor.setId(GeneredId.generatorDoctor());
                        System.out.println("Write new doctor");
                        String doctor1 = new Scanner(System.in).nextLine();
                        doctor.setFirstName(doctor1);
                        System.out.println("Doctor name");
                        System.out.println(doctorService.add(id, doctor));
                    }
                    case 15 -> {
                        System.out.println("write id doctor");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(doctorService.findDoctorById(id));

                    }
                    case 16 -> {
                        System.out.println("write department id");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("write doctor id");
                        Long did = new Scanner(System.in).nextLong();
                        System.out.println(doctorService.assignDoctorToDepartment(id, Collections.singletonList(did)));

                    }
                    case 17 -> {
                        System.out.println("Write id hospital");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(doctorService.getAllDoctorsByHospitalId(id));
                    }
                    case 18 -> {
                        System.out.println("write department id");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(doctorService.getAllDoctorsByDepartmentId(id));

                    }
                    case 19 -> {
                        Patient newPatient = new Patient();
                        newPatient.setId(GeneredId.generatorPatientid());
                        System.out.println("write hospital id");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Enter patient first name");
                        String firstName = new Scanner(System.in).nextLine();
                        newPatient.setFirstName(firstName);
                        System.out.println("enter patient last name ");
                        String lastName = new Scanner(System.in).nextLine();
                        newPatient.setLastName(lastName);
                        System.out.println("Write patient age: ");
                        int age = new Scanner(System.in).nextInt();
                        newPatient.setAge(age);
                        System.out.println("Write patient gender FEMALE/MALE");
                        Gender gender = Gender.valueOf(new Scanner(System.in).nextLine());
                        newPatient.setGender(gender);
                        System.out.println(patientService.add(id, newPatient));

                    }
                    case 20 -> {
                        System.out.println("Enter the id to delete a patient: ");
                        Long id = new Scanner(System.in).nextLong();
                        patientService.removeById(id);
                    }
                    case 21 -> {
                        Patient patient = new Patient();
                        System.out.println("Write the id to update the patient:");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Write new patient firsName");
                        String ferstName = new Scanner(System.in).nextLine();
                        patient.setFirstName(ferstName);
                        System.out.println("Write new patient last name");
                        String lastnaem = new Scanner(System.in).nextLine();
                        patient.setLastName(lastnaem);
                        System.out.println("write new patient age");
                        int age = new Scanner(System.in).nextInt();
                        patient.setAge(age);
                        System.out.println("write new patient gender FEMALE/MAlE");
                        Gender gender = Gender.valueOf(new Scanner(System.in).nextLine());
                        patient.setGender(gender);
                        System.out.println(patientService.upDateById(id, patient));
                    }
                    case 22 -> {
                        Patient newPatient1 = new Patient();
                        Patient newPatient2 = new Patient();
                        List<Patient> list = new ArrayList<>(List.of(newPatient1, newPatient2));
                        System.out.println("write hospital id");
                        Long newId = new Scanner(System.in).nextLong();
                        newPatient1.setId(GeneredId.generatorPatientid());
                        System.out.println("write patient first name");
                        String firstName1 = new Scanner(System.in).nextLine();
                        newPatient1.setFirstName(firstName1);
                        System.out.println("write last name: ");
                        String lastName1 = new Scanner(System.in).nextLine();
                        newPatient1.setLastName(lastName1);
                        System.out.println("write patient age: ");
                        int age = new Scanner(System.in).nextInt();
                        newPatient1.setAge(age);
                        System.out.println("write patient gender FEMALE/MALE");
                        Gender gender = Gender.valueOf(new Scanner(System.in).nextLine());
                        newPatient1.setGender(gender);



                        newPatient2.setId(GeneredId.generatorHospitalid());
                        System.out.println("write patient first name");
                        String firstName2 = new Scanner(System.in).nextLine();
                        newPatient2.setFirstName(firstName2);
                        System.out.println("write last name: ");
                        String lastName2 = new Scanner(System.in).nextLine();
                        newPatient2.setLastName(lastName2);
                        System.out.println("write patient age: ");
                        int age1 = new Scanner(System.in).nextInt();
                        newPatient2.setAge(age1);
                        System.out.println("write patient gender FEMALE/MALE");
                        Gender gender1 = Gender.valueOf(new Scanner(System.in).nextLine());
                        newPatient2.setGender(gender1);
                        System.out.println(patientService.addPatientsToHospital(newId, list));

                    }
                    case 23 -> {
                        System.out.println("Write id patient");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(patientService.getPatientById(id));

                    }
                    case 24 -> {
                        System.out.println("Write the patient's age:");
                        int age = new Scanner(System.in).nextInt();
                        System.out.println(patientService.getPatientByAge(age));

                    }
                    case 25 -> {
                        System.out.println("write patient sort age (asc/desc");
                        String ascOrDesc = new Scanner(System.in).nextLine();
                        System.out.println(patientService.sortPatientsByAge(ascOrDesc));


                    }
                    default -> System.out.println(" ");
                }
            } catch (InputMismatchException e) {
                System.out.println("write number");
            } catch (Exception e) {
                System.out.println("exception wwrite again");
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

