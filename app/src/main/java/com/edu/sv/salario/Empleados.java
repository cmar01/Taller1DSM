package com.edu.sv.salario;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Empleados implements Serializable {

    private String nombre;
    private String apellido;
    private String cargo;
    private double isss;
    private double afp;
    private double renta;
    private float salarioLiquido;
    private String bono;

    DecimalFormat df = new DecimalFormat("#.00");


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getIsss() {
        return isss;
    }

    public void setIsss(double isss) {
        this.isss = isss;
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(float salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public String getBono() {
        return bono;
    }

    public void setBono(String bono) {
        this.bono = bono;
    }

    @Override
    public String toString(){

        return nombre+" | "+apellido+" | "+df.format(isss)+" | "+df.format(afp)+" | "
                +df.format(renta)+" | "+df.format(salarioLiquido)+" | "+bono;
    }

}
