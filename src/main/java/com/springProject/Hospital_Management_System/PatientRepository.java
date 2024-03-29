package com.springProject.Hospital_Management_System;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class PatientRepository {
    HashMap<Integer,Patient> patientDb = new HashMap<>();

    public String addPatient(List<Patient> patient) {
        for(Patient p: patient) {
            int key = p.getPatientId();
            if(key < 0) return "Please enter valid Patient id";
            if(p.getName().equals(null)) return "Please enter valid Patient name";
            patientDb.put(key,p);
        }
        return "Patient added Successfully";
    }
    public List<Patient> getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        for(Patient p : patientDb.values()) {
            patientList.add(p);
        }
        return patientList;
    }
    public String updatePatient(Patient patient) {
        int key = patient.getPatientId();

        if(patientDb.containsKey(key)) {
            patientDb.put(key,patient);
        }
        return "Patient updated Successfully";
    }
    public String deletePatient(int patientId) {
        if(patientId < 0) {
            return "Please enter the valid patient id";
        }
        for(Patient p: patientDb.values()) {
            if(p.getPatientId() == patientId) {
                patientDb.remove(patientId);
            }
        }
        return "Patient Deleted Successfully";
    }
}
