/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemacentro.grupo1;

import Modelo.Comprador;
import Modelo.DetalleTicket;
import Modelo.Funcion;
import Modelo.Lugar;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.TicketCompra;
import Persistencia.CompradorData;
import Persistencia.DetalleTicketData;
import Persistencia.FuncionData;
import Persistencia.LugarData;
import Persistencia.PeliculaData;
import Persistencia.SalaData;
import Persistencia.TicketCompraData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arceb
 */
public class CinemaCentroGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Pelicula peli1 = new Pelicula("El señor de los anillos", "Chritopher Nolan", "Brad pitt", "Estado Unidos", "Aventuras", LocalDate.of(2005, Month.MARCH, 15), true);
//        
//        PeliculaData pelidata = new PeliculaData();
//        
//        pelidata.guardarPelicula(peli1);
//        
        // Pelicula peli2 = new Pelicula("Troya", "Arce Brayan", "Brad pitt, Orlando blum", "Estados Unidos", "Historia", LocalDate.of(2000, Month.MARCH, 16), true);
//        
//        pelidata.guardarPelicula(peli2);
        //-------------Probamos el metodo para buscar la pelicula por el nombre-------------------
//       Pelicula buscada = pelidata.buscarPelicula("El señor de los anillos");
//       
//       if(buscada != null){
//           System.out.println("Pelicula encontrada: " + buscada.toString());
//       
//       }
        //------------Probamos el metodo para listar las peliculas------------------
//        List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//        for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }
        //---------------Prueba de dar de baja a una pelicula (cartelera)-------------
        //pelidata.darBajaCartelera(1);
//        List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//       for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }
        //--------------Prueba dar de alta a una pelicula-------------
//       pelidata.darAltaCartelera(1);
//       List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//       for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }
        //-----------------Prueba eliminar pelicula-----------------
//        pelidata.eliminarPelicula(2);
//        List<Pelicula> peliculaEnCartelera = pelidata.listarPeliculasCartelera();
//        
//       for (Pelicula peli : peliculaEnCartelera) {
//            System.out.println(peli);
//        }
//-------------------------------<<======COMPRADOR DATA=====>>!!---------------
//
//    CompradorData compradorData = new CompradorData();
//    
//----------------creo comprador -----------------
//    
//    Comprador compra1 = new Comprador (41221751, "Gimenez Paula" , "123", "Mercado Pago", LocalDate.of(1998,06,06));
//    
//    compradorData.guardarComprador(compra1);
//    Comprador compra2 = new Comprador (42278291,"Arce Brayan", "231","Efectivo",LocalDate.of(1999,12,16));
//    
//    compradorData.guardarComprador(compra2);
//    
//    
//      Comprador compra3 = new Comprador (39092552,"Aguero Jonatan", "789","Tarjeta",LocalDate.of(1995,9,10));
//    compradorData.guardarComprador(compra3);
//    
//    
//    //---------------buscar comprador por dni
//    
//    Comprador compraBuscar= compradorData.buscarComprador(41221751);
//    
//    System.out.println("Comprador Buscado: "+ compraBuscar);
//    
//    
//    //buscamos uno q no este 
//    
//    Comprador BUSCAR = compradorData.buscarComprador(123456);
//    
//    
//    
//    //----------------------LISTAR COMPRADORES -----------
//     List <Comprador> lista = compradorData.listarCompradores();
//     
//     System.out.println("Listado de compradores");
//     
//     
//     for(Comprador c: lista){
//         System.out.println(c);
//     }
        //----------------ACTUALIZAR COMPRADOR--------------
//    Comprador compraBuscar= compradorData.buscarComprador(41221751);
//    
//    compraBuscar.setMedioDePago("Debito");
//    compradorData.actualizarComprador(compraBuscar);
//    
//     System.out.println("Comprador Actualizado "+ compraBuscar);
//     
//     
//     
//     compradorData.eliminarComprador(compraBuscar.getIdComprador());
//    
//    
//      List <Comprador> lista = compradorData.listarCompradores();
//     
//     System.out.println("Listado de compradores");
//     
//     
//     for(Comprador c: lista){
//         System.out.println(c);
//     }  
//        SalaData salaData = new SalaData();
//
////        // -----------Guardar nueva sala--------
//        Sala sala1 = new Sala(1, true, 200, true);
//        salaData.guardarSala(sala1);
//      System.out.println("Sala guardada: " + sala1);
//       Sala sala2 = new Sala(2, true, 180, true); 
//      salaData.guardarSala(sala2);
//       Sala sala3 = new Sala(3, true, 400, true); 
//       salaData.guardarSala(sala3);
//       // ----- Buscar sala por ID-------------
//       Sala salaBuscada = salaData.buscarSala(4);
//       if (salaBuscada != null) {
//            System.out.println("Sala encontrada: " + salaBuscada);
//        }
//         Sala salaBuscada2 = salaData.buscarSala(8);
//         
//         
//       // ---------------- Listar todas las salas-----------------
//       List<Sala> todasSalas = salaData.listarSalas();
//       System.out.println("Listado de todas las salas:");
//       for (Sala s : todasSalas) {
//            System.out.println(s);
//       }
//
//        // ---------------Actualizar sala----------------
//        salaBuscada.setCapacidad(220);
//        salaBuscada.setApto3d(false);
//        salaData.actualizarSala(salaBuscada);
//        System.out.println("Sala actualizada: " + salaData.buscarSala(salaBuscada.getIdSala()));
//
//        // -----------------Eliminar sala -----------------
//        salaData.eliminarSala(salaBuscada.getIdSala());
//        
//        System.out.println("Sala eliminada");
//        
//         List<Sala> todasSalas2 = salaData.listarSalas();
//       System.out.println("Listado de todas las salas:");
//       for (Sala s : todasSalas2) {
//            System.out.println(s);
//       }
//        FuncionData funcionData = new FuncionData();
//
//        LugarData lugarData = new LugarData();
//        //---------------Prueba de cargar una funcion-----------------
//        Pelicula pelicula = new Pelicula();
//
//        pelicula.setIdPelicula(1);
//
//        Sala sala = new Sala();
//
//        sala.setIdSala(1);
//
//        List<Lugar> lugars = new ArrayList();
//
//        Funcion funcion1 = new Funcion(pelicula, "espanol", false, true, LocalDateTime.of(2025, 12, 16, 16, 30), LocalDateTime.of(2025, 12, 16, 18, 30), lugars, sala, 8000);
//
//        funcionData.guardarFuncion(funcion1);
//
////------------------------PROBAMOS GUARDAR UN LUGAR --------------
//        char[] filas = {'A', 'B', 'C'};
//        int asientosPorFila = 3;
//
//        for (char f : filas) {
//            for (int i = 1; i <= asientosPorFila; i++) {
//                Lugar lugui = new Lugar();
//                lugui.setFila(f);
//                lugui.setNum(i);
//                lugui.setEstado(true);
//                lugui.setFuncion(funcion1);
//
//                lugarData.guardarLugar(lugui);
//                lugars.add(lugui);
//            }
//        }
//       Funcion funcion2 = funcionData.buscarFuncion(13);
//       
//        System.out.println("Lugares asignados");
//        
//        for (Lugar lugar : funcion2.getListaLugaresDisp()) {
//            System.out.println("Fila: " + lugar.getFila() + " num: " + lugar.getNum() + " estado: " + (lugar.isEstado() ? "Libre" : "Ocupado"));
//            
//        }
//       //--------------------Prueba de actualizar una funcion------------------
//       
//       Funcion funcion = new Funcion();
//       
//       funcion.setIdFuncion(6);
//       
//       funcion.setIdioma("Ingles");
//       
//       funcionData.actualizarFuncion(funcion);
//       
        //-------------Prueba para probar el listar funciones---------------
//        System.out.println("Lista de funciones: ");
//        List<Funcion> listaFunciones = funcionData.listarFuncion();
//        
//        
//        for (Funcion f : listaFunciones) {
//            System.out.println("--- Función ID: " + f.getIdFuncion() + " ---");
//            System.out.println("Película: " + f.getPelicula().getTitulo());
//            System.out.println("Sala: " + f.getSalaProyeccion().getNroSala());
//            System.out.println("Horario: " + f.getHoraInicio());
//            System.out.println("Precio: $" + f.getPrecio());
//            System.out.println("Lugares disponibles: " + f.getListaLugaresDisp().size());
//            System.out.println("--------------------------------------\n");
//        }
//        
//    }
//        
//        List<Lugar> buscaLugares = lugarData.buscarLugaresPorFuncion(12);
//        
//        for (Lugar busca : buscaLugares) {
//            System.out.print("Numero " + busca.getNum());
//            System.out.print(" fila: " + busca.getFila());
//            System.out.println(" disponible: " + busca.isEstado());
//        }
//------------ PRUEBA DE LUGAR SIN ASOCIAR UNA FUNCION -------------
//  LugarData lugarData = new LugarData();  
//    
//    
//    Lugar lugar = new Lugar();
//    lugar.setFila('P');
//    lugar.setNum(6);
//    lugar.setEstado(true);
//    lugar.setFuncion(null);
//    
//    
//    lugarData.guardarLugar(lugar);
//    
//    System.out.println("Lugar guardado"+lugar);
//    
        //-------------- actualizar un lugar-----------
        Lugar lugar = new Lugar();
//   lugar=lugarData.buscarLugarPorId(4);
//     lugar.setEstado(false);
//   ------------ dar de baja y alta un ligar------------
//    lugarData.actualizarLugar(lugar);
//    lugarData.darBajaLugar(4);
//    lugarData.darAltaLugar(7);

//------------ Listar lugares------------
//        List<Lugar> lugares = lugarData.listarLugares();
//            for (Lugar l : lugares) {
//                System.out.println("ID: " + l.getIdLugar() +
//                           " | Fila: " + l.getFila() +
//                           " | N°: " + l.getNum() +
//                           " | Estado: " + (l.isEstado() ? "Libre" : "Ocupado"));
//        }
//
//-------------- eliminar un lugar----------------
        //lugarData.eliminarlugar(4);
//----------- Probamos el DetalleTicket --------------
//        DetalleTicketData detalleticketdata = new DetalleTicketData();
//
//        DetalleTicket dticket = new DetalleTicket();
//
////        dticket.setIdDetalleTicket(1);
////        System.out.println(dticket);
//        FuncionData funciondata = new FuncionData();
//
//        Funcion f = new Funcion();
////    
//        Lugar l = new Lugar();
//        l.setIdLugar(10);
////    
//        f.setIdFuncion(2);
////    
//        dticket.setFuncion(f);
////    
//        dticket.setLugar(l);
//
//        dticket.setCantidad(1);
//
//        dticket.setSubtotal(5000);
//    
//        detalleticketdata.guardarDetalleTicket(dticket);
//        dticket.setSubtotal(3000);
//    --------Para actualizar el detalleticket tenemos que pasar la funcion y el lugar parciandola----------
//        detalleticketdata.actualizarDetalleTicket(dticket);
// ------------- Se probo el eliminar
//        detalleticketdata.eliminarDetalleTicket(1);


//          TicketCompraData ticket = new TicketCompraData();
//          
//          TicketCompra t = new TicketCompra();
//          
//          Comprador comprador = new Comprador();
          
          
          


    }

}
