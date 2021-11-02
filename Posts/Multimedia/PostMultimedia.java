/*

    PostMultimedia.java
    Autor: Francisco Javier Castillo Cerna 21562
    Modelo de los Posts de tipo Multimedia, clase madre, hereda de Post

*/

package Posts.Multimedia;

import Posts.Post;
import java.util.ArrayList;
import java.util.Date;

public abstract class PostMultimedia extends Post{
    private String url;
    private int tamanio;
    public PostMultimedia(String url, int tamanio, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(autor, hashtags, fechaDePublicacion);
        this.url = url;
        this.tamanio = tamanio;
    }
    
    /** 
     * @return String Obtiene el URL del archivo de la publicacion multimedia
     */
    protected String getURL(){
        return this.url;
    }
    
    /** 
     * @return int El tamanio del archivo del Post
     */
    protected int getTamanio(){
        return this.tamanio;
    }
    abstract protected String getDetalles();
}