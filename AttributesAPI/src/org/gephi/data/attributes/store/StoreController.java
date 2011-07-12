package org.gephi.data.attributes.store;

import org.gephi.data.attributes.api.AttributeModel;

/**
 *
 * @author Ernesto A
 */
public interface StoreController {
    
    Store newStore(AttributeModel model);
    
    Store getStore(AttributeModel model);
    
    void removeStore(AttributeModel model);
    
    void shutdown();

}
