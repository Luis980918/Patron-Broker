package com.company;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

class SumaImpl extends com.company.sumaApp.sumaPOA {


    private ORB orb;

    public void setORB(ORB orb_val){
        orb=orb_val;
    }


    public int sumar(int primernumero, int segundonumero) {
        return primernumero+segundonumero;
    }

    public void shutdown() {
        orb.shutdown(false);
    }

}

public class SumaServer{
    public static void main(String args[]){
        try{
            ORB orb = ORB.init(args, null);
            POA rootpoa= POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            SumaImpl sumaImpl=new SumaImpl();
            sumaImpl.setORB(orb);

            org.omg.CORBA.Object ref= rootpoa.servant_to_reference(sumaImpl);
            com.company.sumaApp.suma href= com.company.sumaApp.sumaHelper.narrow(ref);
            org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
            NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
            String name="Suma";
            NameComponent path[]=ncRef.to_name(name);
            ncRef.rebind(path, href);
            System.out.println("Servidor de suma listo y en espera");
            orb.run();

        }catch(Exception e){
            System.err.println("Error: "+e);
            e.printStackTrace(System.out);
        }
        System.out.println("Cerrando Servidor");

    }
}
