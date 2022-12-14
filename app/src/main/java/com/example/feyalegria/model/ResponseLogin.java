package com.example.feyalegria.model;

public class ResponseLogin {

    private int idusua;
    private int iddocente;
    private String usuario;
    private String contrasena;
    private int estado;

    public int getIdusua() {
        return idusua;
    }

    public void setIdusua(int idusua) {
        this.idusua = idusua;
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
