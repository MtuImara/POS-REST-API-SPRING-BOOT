package pos.gescom.restApi.depotStockage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(value = Include.NON_NULL)
public class DepotStockageDto {

    private Integer id;
    private String code;
    private String designation;
    private String ville;
    private String pays;
    private String telephone;
    private String email;
    private Boolean depotPrincipal;

    private String dateCreation;
    private String dateModification;

    public DepotStockageDto modifyValues(DepotStockageDto updated) {
        this.setCode(updated.getCode() != null ? updated.getCode() : this.getCode());
        this.setDesignation(
                updated.getDesignation() != null ? updated.getDesignation() : this.getDesignation());
        this.setVille(updated.getVille() != null ? updated.getVille() : this.getVille());
        this.setPays(updated.getPays() != null ? updated.getPays() : this.getPays());
        this.setTelephone(updated.getTelephone() != null ? updated.getTelephone() : this.getTelephone());
        this.setEmail(updated.getEmail() != null ? updated.getEmail() : this.getEmail());
        this.setDepotPrincipal(
                updated.getDepotPrincipal() != null ? updated.getDepotPrincipal()
                        : this.getDepotPrincipal());
        this.setDateCreation(
                updated.getDateCreation() != null ? updated.getDateCreation() : this.getDateCreation());
        this.setDateModification(
                updated.getDateModification() != null ? updated.getDateModification()
                        : this.getDateModification());

        return this;
    }

}
