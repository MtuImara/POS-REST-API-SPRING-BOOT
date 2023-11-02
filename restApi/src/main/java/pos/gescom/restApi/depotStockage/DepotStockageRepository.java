package pos.gescom.restApi.depotStockage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepotStockageRepository
        extends JpaRepository<DepotStockageEntity, Integer>, JpaSpecificationExecutor<DepotStockageEntity> {

    @Query("SELECT count(u) > 0 FROM DepotStockageEntity u  WHERE u.code=:code")
    boolean existsByCode(@Param("code") String code);

    @Query("SELECT G FROM DepotStockageEntity G WHERE G.code=:code and G.id!=:id")
    Optional<DepotStockageEntity> verificationCode(@Param("id") Integer id, @Param("code") String code);

}
