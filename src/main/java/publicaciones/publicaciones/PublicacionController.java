package publicaciones.publicaciones;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.lang.System;

@RestController
public class PublicacionController {
   private List<Publicacion> publicaciones = new ArrayList<>();

    public PublicacionController(){
    //initialize list with data

        publicaciones.add(new Publicacion(1, Arrays.asList(new Comentario("001SPORT", "Alexis Sanchez hace un excelente partido ante Lituania en la victoria 3-0"), 
        new Comentario("002SPORT", "Jugo increible y Eduardo Vargas vuelve a la seleccion"), new Comentario("003SPORT", "Niun brillo los albaneses")),
        llenarListaCalificaciones("ComentarioPositivo", 5.0, 5.0, 4.5))); 

        publicaciones.add(new Publicacion(2, Arrays.asList(new Comentario("001SPORT", "Venezuela casi le empata a Italia"), 
        new Comentario("002SPORT", "Venezuela ha subido mucho el nivel de su futbol"), new Comentario("003SPORT", "Aguante sudamerica")),
        llenarListaCalificaciones("ComentarioPositivo", 4.0, 4.2, 4.5))); 

        publicaciones.add(new Publicacion(3, Arrays.asList(new Comentario("001MODA", "Que feo el vestido"), 
        new Comentario("002MODA", "Esa ropa parece de otra epoca"), new Comentario("003moda", "No me gusta ese tipo cortes")),
        llenarListaCalificaciones("ComentarioNegativo", 2.0, 3.0, 3.5))); 
    }

    private Map<String, List<Double>> llenarListaCalificaciones(String comentario, Double calificacion1, Double calificacion2, Double calificacion3){

        Map<String, List<Double>> retorno = new HashMap<String, List<Double>>();

        List<Double> calificaciones = Arrays.asList(calificacion1,calificacion2,calificacion3);

        retorno.put(comentario, calificaciones);

        return retorno;
    }

    //http://localhost:8080/publicaciones
    @GetMapping("/publicaciones")
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }  
    
    //http://localhost:8080/publicaciones/1
    @GetMapping("/publicaciones/{id}")
    public Publicacion getPublicacionById(@PathVariable int id) {
        for(Publicacion publicacion : publicaciones){
            if(publicacion.getId() == id){
                return publicacion;
            }else{
              System.out.println("The id you are indexing does not exist");
            }
        }
        return null;
    }

    @GetMapping("/publicaciones/{id}/promedio")
    public String getComentarioByPublicacionId(@PathVariable int id) {
        return "por favor ingresar: '/comentario' despues del path http://localhost:8080/publicaciones/1/promedio para el ID: " + id +"."+" El URL que ingresa no mostrara nada";
    }

    //http://localhost:8080/publicaciones/1/promedio/ComentarioPositivo
    @GetMapping(path ="/publicaciones/{idPublicacion}/promedio/{nombreComentario}")
    public Double listarCalificacion(@PathVariable("idPublicacion") Integer idPublicacion,
        @PathVariable("nombreComentario") String nombreComentario){ 
        Double promedio = 0.0;
        for(Publicacion publicacion : publicaciones){
            if (publicacion.getId() == idPublicacion) {
                List<Double> calificaciones = publicacion.getCalificaciones().get(nombreComentario);
                Double suma = 0.0;
                for (Double calificacion : calificaciones) {
                    suma += calificacion;
                }
                promedio = suma / calificaciones.size();
            }
        }
           
        // Replace comma with dot for decimal separator
        String promedioString = String.format("%.1f", promedio).replace(',', '.');
        // Convert the modified string back to Double
        Double result = Double.parseDouble(promedioString);

        // Printing the result
        System.out.println("The calculated average for publicacion ID " + idPublicacion +" and comentario " + nombreComentario + " is: " + result);
        return result;
      
    }
}
