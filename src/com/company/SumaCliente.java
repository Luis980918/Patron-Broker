package com.company;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import com.company.sumaApp.*;

import java.util.Scanner;

public class SumaCliente {
    static suma sumaImpl;
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        try{
            ORB orb= ORB.init(args, null);
            //inicializa orb para enviar peticion
            Object objRef=orb.resolve_initial_references("NameService");
            NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);

            String name="Suma";
            sumaImpl= com.company.sumaApp.sumaHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Ingrese numero 1: ");
            int num1=sc.nextInt();
            System.out.println("Ingrese numero 2: ");
            int num2=sc.nextInt();
            System.out.println("La suma es: "+Integer.toString(sumaImpl.sumar(num1, num2)));
            sumaImpl.shutdown();
        }catch(Exception e){
            System.out.println("Error: "+e);
            e.printStackTrace(System.out);
        }
    }

}
