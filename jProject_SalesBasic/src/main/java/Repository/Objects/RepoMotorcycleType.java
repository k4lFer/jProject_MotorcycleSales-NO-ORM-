package Repository.Objects;

import DTOs.Objects.DtoMotorcycleType;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoMotorcycleType extends RepoGeneric<DtoMotorcycleType>{
    public List<DtoMotorcycleType> getAll();
}
