package com.nextu.jj.examenfinalinterfaces;

/**
 * Created by JJ on 8/2/2017.
 */

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Next University
 */
public class CambiaTema {
    //private static int identificador;
    public final static int primerTema=0;
    public final static int segundoTema=1;


    public static void cambioDeTema(int identificador, Activity activity){
        switch (identificador){
            case primerTema:
                activity.setTheme(R.style.FacebookTheme);
                break;
            case segundoTema:
                activity.setTheme(R.style.InstagramTheme);
                break;

        }


    }

}
