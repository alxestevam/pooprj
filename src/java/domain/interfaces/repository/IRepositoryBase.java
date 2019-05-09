/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.interfaces.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 171150
 */
public interface IRepositoryBase<T, I> {

    T save(T entity);

    void remove(T entity);

    T getById(Class<T> classe, I pk);

    List<T> getAll(Class<T> classe);

}
