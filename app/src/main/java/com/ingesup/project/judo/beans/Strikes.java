package com.ingesup.project.judo.beans;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Changeform on 22/04/2015.
 */
public class Strikes extends ArrayList<Strike> {

    public Strikes search(String textSearched){
        Strikes foundStrikes = new Strikes();

        textSearched = textSearched.toLowerCase();

        for(Strike strike : this){
            if(strike.getName().toLowerCase().contains(textSearched))
                foundStrikes.add(strike);
        }

        return foundStrikes;
    }

    /** PROPERTY **/


    public void orderByProperty(String propertyName){
        orderByProperty(propertyName, true);
    }

    public void orderByProperty(String propertyName, boolean desc){
        try {
            boolean propertyFound = false;
            Field[] strikeFields = Strike.class.newInstance().getClass().getDeclaredFields();
            int i = 0;

            while(!propertyFound && i < strikeFields.length){
                Field f = strikeFields[i];
                if(f.getName().equals(propertyName)){
                    propertyFound = true;
                    tri(f, desc);
                }

                i++;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private boolean comparePropertyValue(Field field, Strike firstStrike, Strike secondStrike, boolean desc){
        Object firstStrikePropertyValue = null;
        Object secondStrikePropertyValue = null;

        field.setAccessible(true);

        try {
            firstStrikePropertyValue = field.get(firstStrike);
            secondStrikePropertyValue = field.get(secondStrike);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if(firstStrikePropertyValue != null && secondStrikePropertyValue != null){
            if(firstStrikePropertyValue instanceof String){
                if(desc)
                    return firstStrikePropertyValue.toString().compareTo(secondStrikePropertyValue.toString()) > 0;
                else
                    return secondStrikePropertyValue.toString().compareTo(firstStrikePropertyValue.toString()) > 0;
            } else if(firstStrikePropertyValue instanceof Integer){
                if(desc)
                    return Integer.valueOf(firstStrikePropertyValue.toString()) > Integer.valueOf(secondStrikePropertyValue.toString());
                else
                    return Integer.valueOf(secondStrikePropertyValue.toString()) > Integer.valueOf(firstStrikePropertyValue.toString());
            } else if(firstStrikePropertyValue instanceof Category){
                Category firstStrikeCategory = (Category) firstStrikePropertyValue;
                Category secondStrikeCategory = (Category) secondStrikePropertyValue;

                if(desc)
                    return firstStrikeCategory.getId() > secondStrikeCategory.getId();
                else
                    return secondStrikeCategory.getId() > firstStrikeCategory.getId();
            }
        }

        return false;
    }

    private void tri(Field field, boolean desc){

        Strike[] strikeTab = toArray(new Strike[size()]);

        int length = strikeTab.length;
        boolean switched;

        do {
            //On considère que le tableau est trié
            switched = false;

            for (int i = 0 ; i < length - 1 ; i++) {

                //On test si les éléments sont dans le bon ordre
                if (comparePropertyValue(field, strikeTab[i], strikeTab[i + 1], desc)) {

                    //Si les éléments n'étaient pas dans le bon ordre, on les place
                    switchStrikes(strikeTab, i, i + 1);
                    //On indique que le tableau n'a pas finis le tri
                    switched = true;
                }
            }
        } while(switched);

        clear();

        addAll(new ArrayList<Strike>(Arrays.asList(strikeTab)));
    }

    /**/


    /** METHOD **/


    public void orderByMethod(String propertyName){
        orderByMethod(propertyName, true);
    }

    public void orderByMethod(String propertyName, boolean desc){
        try {
            boolean propertyFound = false;
            Method[] strikeMethods = Strike.class.newInstance().getClass().getDeclaredMethods();
            int i = 0;

            while(!propertyFound && i < strikeMethods.length){
                Method m = strikeMethods[i];
                if(m.getName().equals(propertyName)){
                    propertyFound = true;
                    tri(m, desc);
                }

                i++;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private boolean compareMethodValue(Method method, Strike firstStrike, Strike secondStrike, boolean desc){
        Object firstStrikePropertyValue = null;
        Object secondStrikePropertyValue = null;

        try {
            firstStrikePropertyValue = method.invoke(firstStrike);
            secondStrikePropertyValue = method.invoke(secondStrike);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if(firstStrikePropertyValue != null && secondStrikePropertyValue != null){
            if(firstStrikePropertyValue instanceof String){
                if(desc)
                    return firstStrikePropertyValue.toString().compareTo(secondStrikePropertyValue.toString()) > 0;
                else
                    return secondStrikePropertyValue.toString().compareTo(firstStrikePropertyValue.toString()) > 0;
            } else if(firstStrikePropertyValue instanceof Integer){
                if(desc)
                    return Integer.valueOf(firstStrikePropertyValue.toString()) > Integer.valueOf(secondStrikePropertyValue.toString());
                else
                    return Integer.valueOf(secondStrikePropertyValue.toString()) > Integer.valueOf(firstStrikePropertyValue.toString());
            } else if(firstStrikePropertyValue instanceof Category){
                Category firstStrikeCategory = (Category) firstStrikePropertyValue;
                Category secondStrikeCategory = (Category) secondStrikePropertyValue;

                if(desc)
                    return firstStrikeCategory.getId() > secondStrikeCategory.getId();
                else
                    return secondStrikeCategory.getId() > firstStrikeCategory.getId();
            }
        }

        return false;
    }


    private void tri(Method method, boolean desc){

        Strike[] strikeTab = toArray(new Strike[size()]);

        int length = strikeTab.length;
        boolean switched;

        do {
            //On considère que le tableau est trié
            switched = false;

            for (int i = 0 ; i < length - 1 ; i++) {

                //On test si les éléments sont dans le bon ordre
                if (compareMethodValue(method, strikeTab[i], strikeTab[i + 1], desc)) {

                    //Si les éléments n'étaient pas dans le bon ordre, on les place
                    switchStrikes(strikeTab, i, i + 1);
                    //On indique que le tableau n'a pas finis le tri
                    switched = true;
                }
            }
        } while(switched);

        clear();

        addAll(new ArrayList<Strike>(Arrays.asList(strikeTab)));
    }

    /**/

    private void switchStrikes(Strike[] strikeTab, int index1, int index2){
        Strike strike1 = strikeTab[index1];

        strikeTab[index1] = strikeTab[index2];
        strikeTab[index2] = strike1;
    }
}
