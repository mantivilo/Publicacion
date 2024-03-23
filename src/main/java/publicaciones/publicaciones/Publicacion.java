package publicaciones.publicaciones;

import java.util.List;
import java.util.Map;

public class Publicacion {
    private int id;
    private List<Comentario> publicacion;
    private Map<String, List<Double>> calificaciones;

    public Publicacion(int id,List<Comentario> publicacion,
         Map<String, List<Double>> calificaciones){

        this.id = id;
        this.publicacion = publicacion;
        this.calificaciones = calificaciones;
    }

    //getters
    public int getId(){
        return id;
    }

    public List<Comentario> getpublicacion(){
        return publicacion;
    }

    public Map<String, List<Double>> getCalificaciones(){
        return calificaciones;
    }

  


}


