package com.springProject.Hospital_Management_System;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatientService {
    PatientRepository patientRepository = new PatientRepository();

    public String addPatient(List<Patient> patient) {
        String ans = patientRepository.addPatient(patient);
        return "Patient added Successfully";
    }
    public List<Patient> getPatient(int patientId) {
        List<Patient> patientList = patientRepository.getAllPatients();
        List<Patient> finalList = new ArrayList<>();

        for(Patient p : patientList) {
            if(p.getPatientId() == patientId) {
                finalList.add(p);
            }
        }
        return finalList;
    }
    public String updatePatient(Patient patient) {
        String ans = patientRepository.updatePatient(patient);
        return "Patient Updated Successfully";
    }
    public String deletePatient(int patientId) {
        if(patientId < 0) {
            return "Please enter the valid patient id";
        }
        return patientRepository.deletePatient(patientId);
    }
}
