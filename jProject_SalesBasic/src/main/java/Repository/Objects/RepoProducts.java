package Repository.Objects;

import DTOs.Objects.DtoProducts;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoProducts extends RepoGeneric<DtoProducts>{
    public List<DtoProducts> getAll();
    public DtoProducts getByCod(String cod);
    
}
