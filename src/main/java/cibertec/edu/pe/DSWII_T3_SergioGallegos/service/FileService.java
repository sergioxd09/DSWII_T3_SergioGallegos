package cibertec.edu.pe.DSWII_T3_SergioGallegos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {
    private final Path rootFolder = Paths.get("archivos");

    public void guardar(MultipartFile archivo) throws Exception{
        Files.copy(archivo.getInputStream(),
                this.rootFolder.resolve(archivo.getOriginalFilename()));
    }

    public void guardarArchivosPDF(List<MultipartFile> archivos) throws Exception {
        for (MultipartFile archivo : archivos) {
            if (!archivo.getContentType().equalsIgnoreCase("application/pdf")) {
                throw new IllegalArgumentException("El archivo no es un PDF.");
            }
            this.guardar(archivo);
        }
    }

    public void guardarArchivosDOC(List<MultipartFile> archivos) throws Exception {
        for (MultipartFile archivo : archivos) {
            if (!archivo.getContentType().equalsIgnoreCase("application/msword")) {
                throw new IllegalArgumentException("El archivo no es un documento Word.");
            }
            if (archivo.getSize() > 2 * 1024 * 1024) { // 2MB en bytes
                throw new IllegalArgumentException("El archivo excede el tamaño máximo permitido (2MB).");
            }
            this.guardar(archivo);
        }
    }

}