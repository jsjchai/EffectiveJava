package provider;

import service.Service;

/**
 * Created by chai on 16-10-25.
 */
public interface Provider {  //Service provider interface

    Service newService();
}
