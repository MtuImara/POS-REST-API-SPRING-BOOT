package pos.gescom.restApi.uploadFiles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UploadFilesMapper {

    @Autowired
    private ModelMapper modelMapper;

    public static UploadFilesMapper getInstance() {
        return new UploadFilesMapper();
    }

    public UploadFilesDto convertAttachementEntityToDTO(
            UploadFilesEntity entity) {
        UploadFilesDto dto = modelMapper.map(entity, UploadFilesDto.class);
        dto.setPath(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()
                + "/Image-Produit/" + entity.getIdImageProduit() + "/" + entity.getNomFichier());
        return dto;
    }

}
