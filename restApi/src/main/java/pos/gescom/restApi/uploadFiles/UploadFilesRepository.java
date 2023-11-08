package pos.gescom.restApi.uploadFiles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UploadFilesRepository extends JpaRepository<UploadFilesEntity, Integer> {

    List<UploadFilesEntity> findByIdImageProduit(Integer idImageProduit);

    @Modifying
    @Transactional
    @Query(value = "delete from produit_attachment_file where id_image_produit=?", nativeQuery = true)
    void deleteByIdImageProduit(Integer id);

}
