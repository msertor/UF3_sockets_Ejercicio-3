
package uf3_sockets_ejercicio.pkg3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
       public static void main(String[] args) throws IOException {
  
   ServerSocket servidor = new ServerSocket(9999);
   Socket misocket=servidor.accept();
   
   DataInputStream flujo_entrada=new DataInputStream(misocket.getInputStream());
   boolean repetir = true;//variable para terminar el loop
   
    
   while (repetir){//loop para que vaya leyendo lo que le envía el cliente hasta que se despida
    String operac = flujo_entrada.readUTF();

       if (operac.contains("+")){
                  int pos = operac.indexOf("+");
                  int primerValor = Integer.parseInt((String)operac.substring(0,pos));
                  int segundoValor = Integer.parseInt((String)operac.substring(pos+1));
                  System.out.println(primerValor + "+" + segundoValor + "=" + (primerValor+segundoValor));
        }
       
       else if (operac.contains("-")){
                  int pos = operac.indexOf("-");
                  int primerValor = Integer.parseInt((String)operac.substring(0,pos));
                  int segundoValor = Integer.parseInt((String)operac.substring(pos+1));
                  System.out.println(primerValor + "-" + segundoValor + "=" + (primerValor-segundoValor));
        }

        else if (operac.matches(".*[S|s]ali(r|da).*")){
                  System.out.println("¡Hasta la próxima!");
                  repetir=false;
        }
   } 
    flujo_entrada.close();
    misocket.close();
    }
}
