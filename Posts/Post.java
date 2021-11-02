/*

    Post.java
    Autor: Francisco Javier Castillo Cerna 21562
    Modelo de los Posts, clase madre para todas las clases del paquete Posts

*/

package Posts;

import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;

public abstract class Post {
    private String autor;
    private Date fechaDePublicacion;
    private int likes;
    private ArrayList<String> comentarios;
    private ArrayList<String> hashtags;

    //SI RECIBE HASHTAGS
    public Post(String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        this.autor = autor;
        this.fechaDePublicacion = fechaDePublicacion;
        this.likes = 0;
        this.comentarios = new ArrayList<>();
        if(hashtags == null){
            this.hashtags = new ArrayList<>();
        }else{
            this.hashtags = hashtags;
        }
    }
    
    /** 
     * @return String EL TEXTO QUE SE MUESTRA AL SELECCIONAR EL POST
     */
    //EL TEXTO QUE SE MUESTRA AL SELECCIONAR EL POST
    public abstract String getPost();

    
    /** 
     * @return String El titulo que representa el post
     */
    public String getTitulo(){
        return "\t Post de: " + this.autor + " | Publicado el: " + this.fechaDePublicacion;
    }
    //EL POST RECIBE UN LIKE
    public void like(){
        this.likes++;
    }
    
    /** 
     * @param comentario El texto del comentario
     */
    //EL POST RECIBE UN COMENTARIO
    public void comentar(String comentario){
        this.comentarios.add(comentario);
    }
    
    /** 
     * @return String el autor del post
     */
    protected String getAutor(){
        return this.autor;
    }
    
    /** 
     * @return Date La fecha de publicacion del post
     */
    public String getFechaDePublicacion(){
        Date date = this.fechaDePublicacion;
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String fecha = localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
        return fecha; 
    }
    
    /** 
     * @return int la cantidad de likes
     */
    protected int getLikes(){
        return this.likes;
    }
    
    /** 
     * @return ArrayList<String> los comentarios de este post
     */
    protected ArrayList<String> getComentarios(){
        return this.comentarios;
    }
    
    /** 
     * @return ArrayList<String> los hashtags de este post
     */
    public ArrayList<String> getHashtags(){
        return this.hashtags;
    }

    public abstract String getEncabezado();
    abstract public String play();
}
