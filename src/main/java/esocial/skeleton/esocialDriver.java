/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esocial.skeleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
* purpose of driver is to create a hard coded entity manager. 
* entity manager will allow commited changes to database.
* 
*/
/**
 *
 * @author conradescandon
 */
public class esocialDriver {
    
    // create an entity manager factory object
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("esocial.skeletonPU");
    
    // create entity manager from emfactory object
    EntityManager em = emf.createEntityManager();
    
    
    
    
    
    
}
