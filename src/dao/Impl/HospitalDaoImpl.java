package dao.Impl;

import dataBase.Database;
import generedId.GeneredId;
import model.Hospital;
import model.Patient;
import service.HospitalService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HospitalDaoImpl implements HospitalService {


    @Override
    public String addHospital(Hospital hospital) {

        return "success";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (Objects.equals(id, hospital.getId())) {
                    return hospital;
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId() == id) {
                return hospital.getPatients();
            }


        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                Database.hospitals.remove(hospital);
                return "удалено";
            }
        }
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalMap = new LinkedHashMap<>();
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getAddress().equalsIgnoreCase(address)) {
                hospitalMap.put(hospital.getHospitalName(), hospital);

            }
        }
        return hospitalMap;
    }


}
