package br.com.bep.argonaut.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class StudentDTO implements Serializable {

    private String name;

    private String identityNumber;

    private LocalDate studentSince;

    private LocalDate birthdate;

    private Long cellphone;

    private String email;

    private String postalCode;

    private String addressLine;

    private double monthlyBill;

    private LocalDate lastpaydate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDate getStudentSince() {
        return studentSince;
    }

    public void setStudentSince(LocalDate studentSince) {
        this.studentSince = studentSince;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public double getMonthlyBill() {
        return monthlyBill;
    }

    public void setMonthlyBill(double monthlyBill) {
        this.monthlyBill = monthlyBill;
    }

    public LocalDate getLastpaydate() {
        return lastpaydate;
    }

    public void setLastpaydate(LocalDate lastpaydate) {
        this.lastpaydate = lastpaydate;
    }
}
