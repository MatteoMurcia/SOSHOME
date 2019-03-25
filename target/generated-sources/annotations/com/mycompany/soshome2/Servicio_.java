package com.mycompany.soshome2;

import com.mycompany.soshome2.Cliente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-24T21:36:23")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> idservice;
    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile SingularAttribute<Servicio, Date> fecha;
    public static volatile SingularAttribute<Servicio, Cliente> cedulac;
    public static volatile SingularAttribute<Servicio, String> nombres;

}