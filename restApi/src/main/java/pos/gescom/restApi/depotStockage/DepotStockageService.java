package pos.gescom.restApi.depotStockage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import pos.gescom.restApi.helpers.DateHelper;
import pos.gescom.restApi.helpers.PagingAndSortingHelper;

@Service
public class DepotStockageService {

    @Autowired
    private DepotStockageRepository depotStockageRepo;

    public Map<String, Object> getAll(String title, int page, int size, String[] sort,
            Specification<DepotStockageEntity> specDepot) {

        Pageable pagingSort = PagingAndSortingHelper.pagination(sort, page, size);

        Page<DepotStockageEntity> depotStockageEntity = null;

        if (title == null || title.equals("")) {
            depotStockageEntity = depotStockageRepo.findAll(specDepot, pagingSort);
        } else {
        }

        List<DepotStockageDto> dtos = new ArrayList<>();

        for (DepotStockageEntity entities : depotStockageEntity) {
            dtos.add(DepotStockageMapper.getInstance().convertToDto(entities));
        }

        Map<String, Object> data = PagingAndSortingHelper.filteredAndSortedResult(
                depotStockageEntity.getNumber(),
                depotStockageEntity.getTotalElements(),
                depotStockageEntity.getTotalPages(),
                dtos);

        return data;
    }

    public DepotStockageDto getById(int id) {

        DepotStockageEntity depotStockageEntity = null;
        try {
            depotStockageEntity = depotStockageRepo.getById(id);
            DepotStockageDto articleDto = DepotStockageMapper.getInstance()
                    .convertToDto(depotStockageEntity);
            return articleDto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DepotStockageDto ajoutDepotStockageService(DepotStockageDto depotStockageDto) {

        try {
            DepotStockageEntity depotStockageEntity = new DepotStockageEntity();
            depotStockageEntity = DepotStockageMapper.getInstance()
                    .convertToEntity(depotStockageDto);
            depotStockageEntity.setDateCreation(DateHelper.now());
            DepotStockageEntity creation = depotStockageRepo.save(depotStockageEntity);

            depotStockageDto = creation != null
                    ? DepotStockageMapper.getInstance().convertToDto(creation)
                    : null;
        } catch (Exception ex) {
            depotStockageDto = null;
            System.out.println("null" + ex.getMessage());
        }

        return depotStockageDto;
    }

    public DepotStockageDto updateDepotStockageService(int id, DepotStockageDto updated) {
        DepotStockageEntity converted_Entity, updated_Entity = null;
        try {

            DepotStockageDto depotStockageDto = getById(id);
            converted_Entity = DepotStockageMapper.getInstance()
                    .convertToEntity(depotStockageDto.modifyValues(updated));
            converted_Entity.setDateModification(DateHelper.now());
            updated_Entity = depotStockageRepo.save(converted_Entity);
            updated = DepotStockageMapper.getInstance().convertToDto(updated_Entity);

        } catch (Exception e) {
            System.out.println("Erreur lors de la modification du Depot de Stockage: " + e.getMessage());
            updated = null;
        }

        return updated;
    }

}
