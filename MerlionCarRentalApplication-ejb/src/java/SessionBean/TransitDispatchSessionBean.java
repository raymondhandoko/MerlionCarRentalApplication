/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(TransitDispatchSessionBeanLocal.class)
@Remote(TransitDispatchSessionBeanRemote.class)
public class TransitDispatchSessionBean implements TransitDispatchSessionBeanRemote, TransitDispatchSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}