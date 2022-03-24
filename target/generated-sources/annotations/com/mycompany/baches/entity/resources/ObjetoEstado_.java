package com.mycompany.baches.entity.resources;

import com.mycompany.baches.entity.resources.Estado;
import com.mycompany.baches.entity.resources.Objeto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-03-24T14:34:35", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(ObjetoEstado.class)
public class ObjetoEstado_ { 

    public static volatile SingularAttribute<ObjetoEstado, Boolean> actual;
    public static volatile SingularAttribute<ObjetoEstado, Estado> idEstado;
    public static volatile SingularAttribute<ObjetoEstado, Objeto> idObjeto;
    public static volatile SingularAttribute<ObjetoEstado, Long> idObjetoEstado;
    public static volatile SingularAttribute<ObjetoEstado, String> observaciones;
    public static volatile SingularAttribute<ObjetoEstado, Date> fechaAlcanzado;

}