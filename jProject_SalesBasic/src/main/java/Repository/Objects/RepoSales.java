
package Repository.Objects;

import DTOs.Objects.DtoSales;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoSales extends RepoGeneric<DtoSales>{
    public List<DtoSales> getAll();    
}
