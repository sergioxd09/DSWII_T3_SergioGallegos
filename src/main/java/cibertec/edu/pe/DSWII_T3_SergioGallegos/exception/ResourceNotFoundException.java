package cibertec.edu.pe.DSWII_T3_SergioGallegos.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}