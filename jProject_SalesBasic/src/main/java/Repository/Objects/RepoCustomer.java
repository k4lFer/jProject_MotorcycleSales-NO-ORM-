package Repository.Objects;

import Objects.DtoCustomer;
import Repository.RepoGeneric;
import java.util.List;

/**
 *
 * @author kalfe
 */
public interface RepoCustomer extends RepoGeneric<DtoCustomer>{
    public List<DtoCustomer> getAll();
    public DtoCustomer getByDni(String dni);
}
