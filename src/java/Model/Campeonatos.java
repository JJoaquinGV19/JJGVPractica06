package Model;
// Generated 12-mar-2021 1:09:04 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Campeonatos generated by hbm2java
 */
public class Campeonatos  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Date fecha;
     private String dniJugador;
     private String imagen;

    public Campeonatos() {
    }

	
    public Campeonatos(int id) {
        this.id = id;
    }
    public Campeonatos(int id, String nombre, Date fecha, String dniJugador, String imagen) {
       this.id = id;
       this.nombre = nombre;
       this.fecha = fecha;
       this.dniJugador = dniJugador;
       this.imagen=imagen;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDniJugador() {
        return this.dniJugador;
    }
    
    public void setDniJugador(String dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    


}


