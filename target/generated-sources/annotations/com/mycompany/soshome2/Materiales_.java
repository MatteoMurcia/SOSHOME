package com.mycompany.soshome2;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Cotizacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-25T18:40:32")
@StaticMetamodel(Materiales.class)
public class Materiales_ { 

    public static volatile SingularAttribute<Materiales, Cotizacion> idcoti;
    public static volatile SingularAttribute<Materiales, Cliente> cedulac;
    public static volatile SingularAttribute<Materiales, String> material;
    public static volatile SingularAttribute<Materiales, Integer> valor;
    public static volatile SingularAttribute<Materiales, String> cantidad;
    public static volatile SingularAttribute<Materiales, String> idmaterial;

}