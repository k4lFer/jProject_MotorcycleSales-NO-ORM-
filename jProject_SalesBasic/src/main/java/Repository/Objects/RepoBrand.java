
package Repository.Objects;

import DTOs.Objects.DtoBrand;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoBrand extends RepoGeneric<DtoBrand>{
    public List<DtoBrand> getAll();    
}
