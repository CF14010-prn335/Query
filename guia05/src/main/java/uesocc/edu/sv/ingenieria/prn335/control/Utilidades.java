package uesocc.edu.sv.ingenieria.prn335.control;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uesocc.edu.sv.ingenieria.prn335.entities.TipoEstadoReserva;

/**
 *
 * @author Steven Castro
 */
@EJB
@Stateless
public class Utilidades {
@PersistenceContext(unitName = "JPA_PU")
        private EntityManager em;
   
//Este metodo ingresa datos a los campos de la entity
public void insert (TipoEstadoReserva entity){
 em.persist(entity);
} 
//Este metodo actualiza los campos de la entity
public void update (TipoEstadoReserva entity){
 em.refresh(entity);
} 
//Este metodo borra un registro de la entity
public void delete (TipoEstadoReserva entity){
em.remove(entity);
} 

//Este metodo devuelve todo los campos de la entity
public List selectAll(){
    Query query = em.createQuery("SELECT ter FROM TipoEstadoReserva ter");
    List List = (List) query;
    return List;
}

public List findByCampos(String busqueda){
   return em.createQuery("select ter from TipoEstadoReserva ter where ter.idTipoEstadoReserva ='" + busqueda + "'").getResultList();
}

public List findRange(int inicio,int fin){
    return em.createQuery("select ter from TipoEstadoReserva WHERE ter.idTipoEstadoReserva BETWEEN '"+inicio+"' AND '"+fin+"'" ).getResultList();
}

public List findByMultiple(String [] campos,String [] busquedas){
 try {
            if (campos.length != 0 || busquedas.length != 0) {
                String concatenar = "(ter.";
                concatenar = concatenar + campos[0] + "=" + busquedas[0];
                for (int i = 1; i < busquedas.length; i++) {
                    for (int j = 1; j < campos.length; j++) {
                        concatenar = concatenar + " OR ter." + campos[j] + "=" + busquedas[i];
                    }
                }
                concatenar = concatenar + ")";
                Query query = em.createQuery("SELECT ter FROM TipoEstadoReserva ter WHERE " + concatenar);
                return query.getResultList();
            } else {
                return null;
            }
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
}
}
