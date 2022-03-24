package com.mycompany.baches.entity.resources;

import com.mycompany.baches.entity.resources.ObjetoEstado;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-24T14:34:35", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, Integer> idEstado;
    public static volatile SingularAttribute<Estado, String> observaciones;
    public static volatile SingularAttribute<Estado, Date> fechaCreacion;
    public static volatile SingularAttribute<Estado, String> nombre;
    public static volatile ListAttribute<Estado, ObjetoEstado> objetoEstadoList;

}