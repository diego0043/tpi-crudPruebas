package com.mycompany.baches.entity.resources;

import com.mycompany.baches.entity.resources.Objeto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-24T14:34:35", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(TipoObjeto.class)
public class TipoObjeto_ { 

    public static volatile SingularAttribute<TipoObjeto, Integer> idTipoObjeto;
    public static volatile SingularAttribute<TipoObjeto, Date> fechaCreacion;
    public static volatile ListAttribute<TipoObjeto, Objeto> objetoList;
    public static volatile SingularAttribute<TipoObjeto, Boolean> activo;

}