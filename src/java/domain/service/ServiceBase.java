/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import infra.data.repository.RepositoryBase;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 141812
 * @param <T>
 * @param <I>
 * @param <K>
 */
public abstract class ServiceBase<I extends Serializable, K extends Number> {
    public final RepositoryBase _repository;

    public ServiceBase(RepositoryBase _repository) {
        this._repository = _repository;
    }
    
    public List<I> getAll(Class<I> classe) {
        return _repository.getAll(classe);
    }
    
    public Serializable getById(Class<I> classe, K id) {
        return _repository.getById(classe, id);
    }
    
    public void save(I obj) {
        _repository.save(obj);
    }
    
    public void remove(I obj) {
        _repository.remove(obj);
    }
}
