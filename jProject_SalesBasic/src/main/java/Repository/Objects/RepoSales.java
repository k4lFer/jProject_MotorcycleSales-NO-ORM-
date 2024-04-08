
package Repository.Objects;

import Objects.DtoSales;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoSales extends RepoGeneric<DtoSales>{
    public List<DtoSales> getAll();    
}
