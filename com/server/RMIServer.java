/**
 * Created by JuanCarlos on 20/02/17.
 */
package com.server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *Juan Carlos Olvera González 151408 juan.olveragz@udlap.mx
 * Gelio Castro Gracida 150604 gelio.castrogd@udlap.mx
 */
public class RMIServer {// Esta clase registra y levanta al servidor

    public static final String RMI_ID = "TestRMI";//Id del servidor
    /**
     * Define el puerto en donde se encuentra el servidor.
     */
    public static final int RMI_PORT = 8080;//Puerto al que se conectara el servidor

    /**
     *
     * @param args
     * @throws AccessException
     * @throws RemoteException
     * @throws AlreadyBoundException
     */
    public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {

        ServerDefinition impl = new ServerDefinition();//Define el servidor
        Registry registry = LocateRegistry.createRegistry(RMI_PORT); // Se registra en el puerto declarado
        registry.bind(RMI_ID, impl);// Enlaza el servidor con el id de su registro

        System.out.println("Server is running...");//Informa al cliente que el servidor ya se levanto
    }
}