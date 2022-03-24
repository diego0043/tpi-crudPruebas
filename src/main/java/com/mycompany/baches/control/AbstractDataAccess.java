/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baches.control;

import java.io.Serializable;
import java.nio.channels.IllegalSelectorException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author J_Die
 * @param <T>
 */
public abstract class AbstractDataAccess<T> implements Serializable {

    protected final Class clase;

    public AbstractDataAccess(Class clase) {
        this.clase = clase;
    }

    abstract EntityManager getEntityManager();

    /**
     * Se encarga de crear un nuevo registro en el repositorio
     *
     * @param nuevo Entidad a persistir
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    public void crear(T nuevo) throws IllegalArgumentException, IllegalStateException {

        if (nuevo != null) {
            EntityManager em = null;
            try {
                em = this.getEntityManager();
            } catch (Exception ex) {
                throw new IllegalStateException("No se puede obtener un ambito de persistencia");
            }
            if (em != null) {
                try {
                    em.persist(nuevo);
                    return;
                } catch (Exception ex) {
                    throw new IllegalStateException("No se pudo crear el registro");
                }
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    /**
     * Encargado de buscar un registro por ID
     *
     * @param id
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    public T findById(final Object id) throws IllegalArgumentException, IllegalStateException {
        if (id != null) {

            EntityManager em = null;
            try {
                em = this.getEntityManager();
            } catch (Exception ex) {
            }

            if (em != null) {
                return (T) em.find(clase, id);
            }
            throw new IllegalStateException("No se pudo obtener el ambito de persistencia");
        }

        throw new IllegalArgumentException();
    }

    /**
     * Obtener todos los datos almacenas en una tabla
     *
     * @return
     */
    public List<T> findAll() {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception ex) {
        }
        if (em != null) {
            TypedQuery q = this.generarConsultaBase(em);
            List salida = q.getResultList();
            if (salida != null) {
                return salida;
            }

            return Collections.EMPTY_LIST;
        }
        throw new IllegalArgumentException("No se puede obtener un ambito de persistencia");

    }

    public List<T> findRange(int first, int pageSize) {

        if (first >= 0 && pageSize > 0) {
            EntityManager em = null;
            try {
                em = this.getEntityManager();
            } catch (Exception ex) {
            }
            if (em != null) {
                TypedQuery q = this.generarConsultaBase(em);
                q.setFirstResult(first);
                q.setMaxResults(pageSize);
                List salida = q.getResultList();
                if (salida != null) {
                    return salida;
                }

                return Collections.EMPTY_LIST;
            }
            throw new IllegalStateException("No se puede obtener un ambito de persistencia");
        }
        throw new IllegalArgumentException("No se puede obtener un ambito de persistencia");

    }

    /**
     * Crear consultas query
     *
     * @param em
     * @return
     */
    protected TypedQuery generarConsultaBase(EntityManager em) {

        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(clase);
            Root<T> raiz = cq.from(clase);
            cq.select(raiz);
            return em.createQuery(cq);
        }

        throw new IllegalArgumentException();
    }

    /**
     * Cuenta las tuplas en el repositorio
     *
     * @return numero de tuplas
     * @throws IllegalStateException Si no se puede obtener una referencia al
     * EntityManager
     */
    public Long contar() throws IllegalStateException {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception ex) {
        }
        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            cq.select(cb.count(cq.from(clase)));
            return em.createQuery(cq).getSingleResult();
        }
        throw new IllegalStateException("No se puede obtener un ambito de persistencia");

    }

    public void eliminar(T registro) throws IllegalStateException, IllegalArgumentException {

        if (registro != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
            }
            if (em != null) {
                if (!em.contains(registro)) {
                    registro = em.merge(registro);
                }
                em.remove(registro);
                return;
            }
            throw new IllegalStateException("El entityManager es nulo");
        }

        throw new IllegalArgumentException("El objeto a eliminar es nulo");

    }

    public void actualizar(T datos) throws IllegalArgumentException, IllegalStateException {
        if (datos != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
                throw new IllegalStateException("No se puede crear el ambito de persistencia");
            }
            if (em != null) {
                em.merge(datos);
                return;
            } else {
                throw new IllegalStateException("El entityManger es nulo");
            }

        }
        throw new IllegalArgumentException("El objeto a actualizar es nulo");
    }

}
