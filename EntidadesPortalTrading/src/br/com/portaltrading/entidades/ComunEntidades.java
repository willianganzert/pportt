/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import java.lang.reflect.Field;

/**
 *
 * @author Willian
 */
public class ComunEntidades implements Cloneable {
//    public <T>T clone(Class<T> c)
//    {
//        T novaInstancia = null;
//        try
//        {
//            novaInstancia = c.newInstance();
//            Field[] fields = this.getClass().getDeclaredFields();
//            for (int i = 0; i < fields.length; i++) {
//                Field field = fields[i];
//                field.setAccessible(true);
//                field.set(novaInstancia, field.get(this));                
//            }
//        }
//        catch(Exception ex)
//        {
//        }
//        return novaInstancia;
//    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
