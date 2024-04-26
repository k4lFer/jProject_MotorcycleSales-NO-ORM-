package Repository.Objects;

import DTOs.Objects.DtoSalesDetails;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoSalesDetails extends RepoGeneric<DtoSalesDetails>{
    public List<DtoSalesDetails> getAll();
    
}
