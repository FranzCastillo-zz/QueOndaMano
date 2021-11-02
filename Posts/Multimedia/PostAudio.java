/*

    PostAudio.java
    Autor: Francisco Javier Castillo Cerna 21562
    Modelo de los Posts de tipo Audio, hereda de PostMultimedia

*/

package Posts.Multimedia;

import java.util.ArrayList;
import java.util.Date;

public class PostAudio extends PostMultimedia {
    private double sampleRate;
    private int bitDepth;

    public PostAudio(double sampleRate, int bitDepth, String url, int tamanio, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(url, tamanio, autor, hashtags, fechaDePublicacion);
        this.sampleRate = sampleRate;
        this.bitDepth = bitDepth;
    }
    
    /** 
     * @return String Los detalles del archivo del post
     */
    protected String getDetalles(){
        String detalles = "Detalles: " + this.getTamanio() + " KB, Sample Rate: " + this.sampleRate + "kHz, Bit Depth: " + this.bitDepth + "\n";
        return detalles;
    }
    
    /** 
     * @return String El post expandido
     */
    public String getPost(){
        String post = "";
        post += "-------------------------------------------------\n";
        post += this.getAutor() + " publico el " + this.getFechaDePublicacion() + "\n";
        post += "Hashtags: ";
        for (String hashtag : this.getHashtags()) {
            post += hashtag + " ";
        }
        post += "\n";
        post += "Likes: " + this.getLikes() + "\n\n";
        post += "(audio) " + this.getURL() + "\n\n";
        post += ">>>>> Comentarios:\n";
        int i = 1;
        for (String comentario : this.getComentarios()) {
            post += "(" + i++ + ")\t" + comentario + "\n";
        }
        post += this.getDetalles();
        post += "-------------------------------------------------\n";
        return post;
    }
    
    /** 
     * @return String el efecto de reproducir el audio
     */
    public String play(){
        String play = "*se esta reproduciendo este audio (" + this.getURL() + ") con " + this.sampleRate + " kHz de Sample Rate y "+ this.bitDepth +" de Bit Depth*";
        return play;
    }
    
    /** 
     * @return String el encabezado para seleccionar este post.
     */
    public String getEncabezado(){
        String encabezado = "(Audio) De " + this.getAutor() + ". Publicdo el: " + this.getFechaDePublicacion();
        return encabezado;
    }
}