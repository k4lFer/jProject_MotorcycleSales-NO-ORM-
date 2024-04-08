/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
