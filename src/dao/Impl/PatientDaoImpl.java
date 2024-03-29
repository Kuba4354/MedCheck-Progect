package dao.Impl;

import dataBase.Database;
import generic.GenericService;
import model.Department;
import model.Hospital;
import model.Patient;
import service.PatientService;

import java.util.*;

public class PatientDaoImpl implements PatientService, GenericService<Patient> {

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                hospital.getPatients().addAll(patients);

            }
        }
        return "success";
    }

    @Override
    public Patient getPatientById(Long id) {
        Patient result = null;
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId().equals(id)) {
                    result = patient;
                    break;
                }
            }
            if (result != null) break;
            {
                throw new IllegalArgumentException("Patient by" + id + "not found");
            }
        }

        return result;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> newMap = new LinkedHashMap<>();
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getAge() == age) {
                    newMap.put(patient.getAge(), patient);
                }
            }
        }
        return newMap;
    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        for (Hospital hospital : Database.hospitals) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                hospital.getPatients().sort(Comparator.comparing(Patient::getAge));
                return hospital.getPatients();
            } else if (ascOrDesc.equals("desc")) {
                hospital.getPatients().sort(Comparator.comparing(Patient::getAge).reversed());
                return hospital.getPatients();

            }
        }
        return null;
    }


    @Override
    public Patient add(Long hospitalId, Patient patient) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getPatients().add(patient);

            }

        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            Iterator<Patient> iterator = hospital.getPatients().iterator();
            while (iterator.hasNext()) {
                Patient patient1 = iterator.next();
                iterator.remove();
                if (patient1.getId().equals(id)) {
                    hospital.getPatients().remove(patient1);
                }

            }

        }
    }


    @Override
    public String upDateById(Long id, Patient patient) {
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient1 : hospital.getPatients()) {
                if (patient1.getId().equals(id)) {
                    patient1.setFirstName(patient.getFirstName());

                }
            }
        }
        return null;
    }


}

