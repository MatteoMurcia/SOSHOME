package com.mycompany.soshome2;

import com.mycompany.soshome2.Materiales;
import com.mycompany.soshome2.Proveedor;
import com.mycompany.soshome2.Servicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-24T21:36:23")
@StaticMetamodel(Cotizacion.class)
public class Cotizacion_ { 

    public static volatile SingularAttribute<Cotizacion, String> idcoti;
    public static volatile SingularAttribute<Cotizacion, Servicio> idservice;
    public static volatile CollectionAttribute<Cotizacion, Materiales> materialesCollection;
    public static volatile SingularAttribute<Cotizacion, String> estado;
    public static volatile SingularAttribute<Cotizacion, Proveedor> cedulap;
    public static volatile SingularAttribute<Cotizacion, String> comentario;
    public static volatile SingularAttribute<Cotizacion, String> estimaciontiempo;

}