package pos.gescom.restApi.depotStockage;

import pos.gescom.restApi.helpers.DateHelper;

public class DepotStockageMapper {

    public DepotStockageMapper() {
    }

    public static DepotStockageMapper getInstance() {
        return new DepotStockageMapper();
    }

    public DepotStockageEntity convertToEntity(DepotStockageDto dto) {

        DepotStockageEntity entity = new DepotStockageEntity();

        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setDesignation(dto.getDesignation());
        entity.setVille(dto.getVille());
        entity.setPays(dto.getPays());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        entity.setDepotPrincipal(dto.getDepotPrincipal());
        entity.setDateCreation(DateHelper.toDate(dto.getDateCreation()));

        return entity;
    }

    public DepotStockageDto convertToDto(DepotStockageEntity entity) {
        DepotStockageDto dto = new DepotStockageDto();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDesignation(entity.getDesignation());
        dto.setVille(entity.getVille());
        dto.setPays(entity.getPays());
        dto.setTelephone(entity.getTelephone());
        dto.setEmail(entity.getEmail());
        dto.setDepotPrincipal(entity.getDepotPrincipal());

        dto.setDateCreation(DateHelper.toText(entity.getDateCreation(), "time"));
        dto.setDateModification(DateHelper.toText(entity.getDateModification(), "time"));

        return dto;
    }

}
