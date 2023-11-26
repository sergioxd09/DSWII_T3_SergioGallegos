package cibertec.edu.pe.DSWII_T3_SergioGallegos.exception;

public class MaxUploadSizeExceedException extends RuntimeException {
    public MaxUploadSizeExceedException (String message){
        super(message);
    }
}