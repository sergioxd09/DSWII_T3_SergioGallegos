package cibertec.edu.pe.DSWII_T3_SergioGallegos.repository;


import cibertec.edu.pe.DSWII_T3_SergioGallegos.model.response.BD.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends
        JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nombrerol);
}