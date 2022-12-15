package com.example.feyalegria.model;

public class RequestAsistencia {

    private int idasistencia;
    private int iddocente;
    private String observacion;
    private String fh_asistencia;
    private int estado;
    private String qr;
    private String porcod;

    public int getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(int idasistencia) {
        this.idasistencia = idasistencia;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFh_asistencia() {
        return fh_asistencia;
    }

    public void setFh_asistencia(String fh_asistencia) {
        this.fh_asistencia = fh_asistencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getPorcod() {
        return porcod;
    }

    public void setPorcod(String porcod) {
        this.porcod = porcod;
    }
}
