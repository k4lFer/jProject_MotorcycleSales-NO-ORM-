package Repository;

/**
 *
 * @author kalfe
 */
public interface RepoGeneric <Dto>{
    public int insert(Dto dto);
    public int update(Dto dto);
    public int delete(int id);
    public Dto getById(int id);     
}
