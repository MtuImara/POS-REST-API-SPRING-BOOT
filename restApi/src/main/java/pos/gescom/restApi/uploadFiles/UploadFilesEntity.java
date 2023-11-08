package pos.gescom.restApi.uploadFiles;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pos.gescom.restApi.fichiersExploitations.produit.ProduitEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "produit_attachment_file")
public class UploadFilesEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_fichier")
    private String nomFichier;

    @Column(name = "id_image_produit")
    private Integer idImageProduit;

    @ManyToOne
    @JoinColumn(name = "id_image_produit", referencedColumnName = "id", insertable = false, updatable = false)
    private ProduitEntity attachementFiles;

}
