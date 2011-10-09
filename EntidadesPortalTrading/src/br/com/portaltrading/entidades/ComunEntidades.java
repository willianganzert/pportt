/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portaltrading.entidades;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public long getId()
    {
        long id = 0;
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.getAnnotation(javax.persistence.Id.class) != null){
                field.setAccessible(true);
                try {
                    id = field.getLong(this);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ComunEntidades.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ComunEntidades.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        return id;
    }
}
