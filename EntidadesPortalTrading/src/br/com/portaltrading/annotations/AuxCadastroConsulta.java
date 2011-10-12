/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Willian
 */
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AuxCadastroConsulta {
    public static enum TIPO_CAMPO{TEXT,AREA,COMBO,CHECK,RADIO};
    public static enum TIPO_DADO{ALFA,NUMERICO,POSITIVO};
    
    boolean listaCadastro() default true;
    boolean listaConsulta() default true;    
    boolean requerido() default false;
    boolean pai() default false;
    int length() default -1;
    TIPO_CAMPO tipoCampo() default TIPO_CAMPO.TEXT ;
    TIPO_DADO tipoDado() default TIPO_DADO.ALFA ;
    
}
