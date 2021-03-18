/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.*;
import Persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author magda
 */
public class Consultas {
    public static ArrayList<Jugadores> iniciaSesion(String nombre, String pass) {
      
        Session session = null;
        ArrayList<Jugadores> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Jugadores where nombre='"+nombre+"' and pass='"+pass+"'");
        array = (ArrayList<Jugadores>) query.list();
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        return array;
    }
    
    public static ArrayList<Juegos> devuelveJuegos(String dni) {
      
        Session session = null;
        ArrayList<Juegos> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Juegos where dni_cliente='"+dni+"'");
        array = (ArrayList<Juegos>) query.list();
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        return array;
    }
    
    public static ArrayList<Juegos> devuelveJuegosFiltrados(String dni, String nombre) {
      
        Session session = null;
        ArrayList<Juegos> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Juegos where dni_cliente='"+dni+"' and nombre='"+nombre+"'");
        array = (ArrayList<Juegos>) query.list();
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        return array;
    }
    
    public static ArrayList<Partidas> devuelvePartidas(String id) {
      
        Session session = null;
        ArrayList<Partidas> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Partidas where id_juegos="+id);
        array = (ArrayList<Partidas>) query.list();
        
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        calculaPtosTotal(array, id);
        return array;
    }
    
    public static void calculaPtosTotal(ArrayList<Partidas> x, String id) {
      
        Session session = null;
        int suma=0;
        ArrayList<Partidas> array = x;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        
        for(int i=0; i < array.size(); i++){
            suma=suma+array.get(i).getPtos();
        }
        
        Query query = session.createQuery("update Juegos set total_ptos="+suma+" where id="+id);
        query.executeUpdate();
        
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.beginTransaction().commit();
            session.clear();
            session.close();
            }
        }
    }
    
    public static ArrayList<Campeonatos> devuelveCampeonatos(String dni) {
      
        Session session = null;
        ArrayList<Campeonatos> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Campeonatos where dni_jugador='"+dni+"'");
        array = (ArrayList<Campeonatos>) query.list();
        
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        
        //ORDENAR ARRAYLIST
        Collections.sort(array, new Comparator<Campeonatos>(){
            @Override
            public int compare(Campeonatos p1, Campeonatos p2) {
                    return p1.getFecha().compareTo(p2.getFecha());
            }
        });
        
        return array;
    }
    
    public static ArrayList<Campeonatos> devuelveCampeonatosFiltrados(String dni, String fecha) {
      
        Session session = null;
        ArrayList<Campeonatos> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Campeonatos where dni_jugador='"+dni+"' and fecha='"+fecha+"'");
        array = (ArrayList<Campeonatos>) query.list();
        
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        return array;
    }
    
    public static void insertarJuego(String nombre, int precio, String dni){
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            int max = obtenerMax().size()+1;
            
            Juegos juegos = new Juegos(max, nombre, precio, 0, dni);
            
            session.save(juegos);
        } catch (HibernateException HE){
            System.err.println(HE.getCause());
            System.err.println("Error doing a select.");
        } finally {
            if (session != null){
                session.beginTransaction().commit();
                session.close();
            }
        }
    }
    
     public static ArrayList<Juegos> obtenerMax() {
      
        Session session = null;
        ArrayList<Juegos> array = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Juegos");
        array = (ArrayList<Juegos>) query.list();
        } catch (HibernateException HE){

        System.err.println(HE.getCause());
        System.err.println("Error doing a trabajo select.");
        } finally {
            if (session != null){
            session.close();
            }
        }
        return array;
    }
}
