package generedId;

public class GeneredId {
    public static long doctorID = 0L;
    public static long patientID = 0L;
    public static long hospitalID = 0L;
    public static long departmentID = 0L;

    public static long generatorDoctor() {
        return (++doctorID);
    }

    public static long generatorPatientid() {
        return (++patientID);
    }

    public static long generatorHospitalid() {
        return (++hospitalID);
    }

    public static long generatorDepartmentid() {
        return (++departmentID);
    }


}
