package com.company.sumaApp;


/**
* com.company.sumaApp/sumaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from suma.idl
* viernes 11 de diciembre de 2020 11:47:44 PM COT
*/

abstract public class sumaHelper
{
  private static String  _id = "IDL:com.company.sumaApp/suma:1.0";

  public static void insert (org.omg.CORBA.Any a, com.company.sumaApp.suma that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.company.sumaApp.suma extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sumaHelper.id (), "suma");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.company.sumaApp.suma read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (com.company.sumaApp._sumaStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.company.sumaApp.suma value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static com.company.sumaApp.suma narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.company.sumaApp.suma)
      return (com.company.sumaApp.suma)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.company.sumaApp._sumaStub stub = new com.company.sumaApp._sumaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static com.company.sumaApp.suma unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.company.sumaApp.suma)
      return (com.company.sumaApp.suma)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.company.sumaApp._sumaStub stub = new com.company.sumaApp._sumaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}