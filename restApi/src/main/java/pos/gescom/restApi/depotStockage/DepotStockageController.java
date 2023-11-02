package pos.gescom.restApi.depotStockage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import pos.gescom.restApi.helpers.MessageHelper;
import pos.gescom.restApi.helpers.ResponseHelper;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/depot_stockage")
public class DepotStockageController {

    @Autowired
    private DepotStockageService depotStockageService;

    @Autowired
    DepotStockageRepository depotStockageRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDepotStockageController(@RequestParam(required = false) String title,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort,
            @Or({
                    @Spec(path = "code", params = "name", spec = LikeIgnoreCase.class),
                    @Spec(path = "designation", params = "name", spec = LikeIgnoreCase.class) }) Specification<DepotStockageEntity> specDepot) {

        Map<String, Object> depotStockage = depotStockageService.getAll(title, page - 1, size, sort, specDepot);

        if (depotStockage.size() > 0) {
            return new ResponseEntity<>(new ResponseHelper(MessageHelper.success(), depotStockage, true),
                    HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new ResponseHelper(MessageHelper.noContent()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getByIdDepotStockageController(@PathVariable(name = "id", required = true) int id) {
        DepotStockageDto depotStockageDto = depotStockageService.getById(id);
        if (depotStockageDto != null) {
            return new ResponseEntity<>(new ResponseHelper(depotStockageDto, true), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseHelper(MessageHelper.notFound(), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/depot_feign_client/{id}", method = RequestMethod.GET)
    public ResponseEntity<DepotStockageDto> getByIdDepotStockageDtoFeignClientController(
            @PathVariable(name = "id", required = true) int id) {
        DepotStockageDto depotStockage = depotStockageService.getById(id);
        if (depotStockage != null) {
            return new ResponseEntity<DepotStockageDto>(depotStockage, HttpStatus.OK);
        } else {
            return new ResponseEntity<DepotStockageDto>(new DepotStockageDto(), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> ajouterDepotStockageController(@RequestBody DepotStockageDto depotStockageDto) {

        DepotStockageEntity depotStockageEntity = DepotStockageMapper.getInstance()
                .convertToEntity(depotStockageDto);

        if (depotStockageRepository.existsByCode(depotStockageEntity.getCode())) {
            return new ResponseEntity<>(
                    new ResponseHelper(MessageHelper.dataExist("code"), true),
                    HttpStatus.BAD_REQUEST);
        } else {
            DepotStockageDto dtos = depotStockageService
                    .ajoutDepotStockageService(depotStockageDto);
            return new ResponseEntity<>(
                    new ResponseHelper(MessageHelper.createdSuccessfully(), dtos, true),
                    HttpStatus.CREATED);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> modifierDepotStockageController(@PathVariable(name = "id", required = true) int id,
            @RequestBody DepotStockageDto depotStockageDto) {

        Optional<DepotStockageEntity> idOptional = depotStockageRepository.findById(id);

        Optional<DepotStockageEntity> codeExist = depotStockageRepository.verificationCode(id,
                depotStockageDto.getCode());

        if (idOptional.isPresent()) {

            if (codeExist.isPresent()) {
                return new ResponseEntity<>(
                        new ResponseHelper(("code " + depotStockageDto.getCode() + " exist"), true),
                        HttpStatus.BAD_REQUEST);
            } else {
                DepotStockageDto depotStockageDto2 = depotStockageService.updateDepotStockageService(id,
                        depotStockageDto);

                return new ResponseEntity<>(
                        new ResponseHelper(MessageHelper.updatedSuccessfully("Depot de Stockage"), depotStockageDto2,
                                true),
                        HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(
                    new ResponseHelper(MessageHelper.notFound("Depot de Stockage avec id: " + id), false),
                    HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> supprimerDepotStockageController(@PathVariable("id") int id) {
        Optional<DepotStockageEntity> idOptional = depotStockageRepository.findById(id);

        try {
            if (idOptional.isPresent()) {
                depotStockageRepository.deleteById(id);
                return new ResponseEntity<>(new ResponseHelper(MessageHelper.success(), true), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseHelper(
                        MessageHelper.notFound("ID"), false), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseHelper(MessageHelper
                    .internalServer(), false),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
