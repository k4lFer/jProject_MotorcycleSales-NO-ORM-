package Repository.Objects;

import Objects.DtoProducts;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoProducts extends RepoGeneric<DtoProducts>{
    public List<DtoProducts> getAll();
    
    
}
