
package uf3_sockets_ejercicio.pkg3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    static Scanner scannerSTR = new Scanner(System.in, "ISO-8859-1");
    public static void main(String[] args) throws Exception{    
        Socket misocket=new Socket ("localhost",9999);
        
        boolean repetir = true;//esta variable la uso para saber cuándo acaba el loop
        
        DataOutputStream flujo_salida=new DataOutputStream(misocket.getOutputStream());
    
        while (repetir){
        System.out.println("Introduce una suma o una resta o escribe 'Salir' para salir:");
        String operac = scannerSTR.nextLine();
        flujo_salida.writeUTF(operac);
            if(operac.matches(".*[S|s]ali(r|da).*")){
            repetir=false;
            } 
        } 
        flujo_salida.close();
        misocket.close();
    }
}

