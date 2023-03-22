package com.springProject.Hospital_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/patient")
public class PatientController {

    PatientService patientService = new PatientService();
    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        String ans = patientService.addPatient(patient);
        return "Patient added Successfully";
    }
    @GetMapping("/get")
    public List<Patient> getPatient (@RequestParam ("patientId") Integer patientId) {
        List<Patient> patientList = patientService.getPatient(patientId);
        return patientList;
    }
    @PutMapping("/update")
    public String updatePatient(@RequestBody Patient patient) {
        String ans = patientService.updatePatient(patient);
        return "Patient Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientId") Integer patientId) {
        String ans = patientService.deletePatient(patientId);
        return "Patient deleted Successfully";
    }
}
