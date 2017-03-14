/**
 * Created by JuanCarlos on 20/02/17.
 */
package com.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.interf.test.TestRemote;

/**
 *Juan Carlos Olvera González 151408 juan.olveragz@udlap.mx
 * Gelio Castro Gracida 150604 gelio.castrogd@udlap.mx
 */
public class TestClient {

    //Se conecta con el servidor y se ejecutan los metodos remotos

    public static final String RMI_ID = "TestRMI";//ID del servidor
    /**
     * Define el puerto en donde se encuentra el servidor.
     */
    public static final int RMI_PORT = 8080;//Puerto al que se va a conectar
    static Scanner scan = new Scanner(System.in);//Con esto se reciben inputs del cliente para decidir la siguiente acción

    public static void main(String[] args) throws RemoteException, NotBoundException {
        //Referencia al servidor registrado de acuerdo a su puerto especifico
        Registry registry = LocateRegistry.getRegistry("localhost", RMI_PORT);
        TestRemote remote = (TestRemote) registry.lookup(RMI_ID);//Invoca metodos de manera remota de acuerdo al servidor registrado
        System.out.println("Qué desea hacer?");//Indice de acciones que puede realizar el cliente
        System.out.println("1.Test del Servidor\n"+ "2.Multiplicación de 2 números\n"+"3.Verificar si la palabra es palindromo");

        try {
            int num = scan.nextInt();
            switch (num){
                //Se hace la llamada al metodo correspondiente de acuerdo al input del usuario
                case 1:
                    System.out.println("Ingresar número");
                    String case1= scan.next();
                    System.out.println(remote.test(case1));
                    break;
                case 2:
                    System.out.println("Introducir primer número");
                    int num1 = scan.nextInt();
                    System.out.println("Introducir segundo numero");
                    int num2 = scan.nextInt();
                    System.out.println("El resultado es: " + remote.multiplicacion(num1,num2));
                    break;
                case 3:
                    System.out.println("Introduce una palabra");
                    String palabra= scan.next();
                    System.out.println(remote.palindromo((palabra)));
                    break;
            }
        }
        catch (Exception e){

        }
    }

}