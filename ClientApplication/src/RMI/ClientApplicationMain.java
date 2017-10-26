package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author vulst
 */
public class ClientApplicationMain {

    private void startClientServer() {
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            // create a new service named ClientApplicationService
            registry.rebind("ClientApplicationService", new ClientApplicationBackendImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("system is ready");
    }


    public static void main(String[] args) {
        ClientApplicationMain clientapp = new ClientApplicationMain();
        clientapp.startClientServer();
    }

}
