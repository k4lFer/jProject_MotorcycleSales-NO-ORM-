
package Repository.Objects;

import Objects.DtoBrand;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoBrand extends RepoGeneric<DtoBrand>{
    public List<DtoBrand> getAll();    
}
