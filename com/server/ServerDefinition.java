/**
 * Created by JuanCarlos on 20/02/17.
 */

package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.TestRemote;

/**
 *Juan Carlos Olvera González 151408 juan.olveragz@udlap.mx
 * Gelio Castro Gracida 150604 gelio.castrogd@udlap.mx
 */
public class ServerDefinition extends UnicastRemoteObject implements TestRemote {// Se implementan los metodos que llevara a cabo el servidor

    /**
     * Identificador único de la serialización (Default).
     */
    private static final long serialVersionUID = 1L;

    protected ServerDefinition() throws RemoteException {
        super();
    }

    @Override
    public Boolean test(String test) throws RemoteException {// este prueba que el servidor reciba una cadena que sea igual a otra
        if(test.equalsIgnoreCase("test")) return true;
        return false;
    }

    public int multiplicacion (int x, int y) throws RemoteException{//Realiza la multiplicacion
        int z;
        z= x*y;
        return z;
    }

    public Boolean palindromo (String a) throws RemoteException{//Checa que la cadena ingresada por el cliente sea un palindromo
        String b = "";
        int i  = a.length()-1;

        while (i>=0 ){
            b= b + a.charAt(i);
            i--;
        }
        if (a.equals(b)){
            return true;
        }
        else
            return false;
    }

}