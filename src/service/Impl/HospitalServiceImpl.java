package service.Impl;

import dao.Impl.HospitalDaoImpl;
import dataBase.Database;
import model.Hospital;
import model.Patient;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    HospitalDaoImpl hospitalDaoImpl = new HospitalDaoImpl();

    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDaoImpl.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDaoImpl.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDaoImpl.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDaoImpl.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDaoImpl.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {

        return hospitalDaoImpl.getAllHospitalByAddress(address);
    }
}
