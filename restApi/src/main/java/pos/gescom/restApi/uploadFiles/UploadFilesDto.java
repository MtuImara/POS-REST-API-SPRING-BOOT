package pos.gescom.restApi.uploadFiles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadFilesDto {
    private Integer id;
    private String nomFichier;
    private String path;

    public UploadFilesDto(String nomFichier, String path) {
        this.nomFichier = nomFichier;
        this.path = path;
    }
}
