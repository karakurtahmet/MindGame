package com.karakurt.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatDrawableManager;

@SuppressLint("ViewConstructor")
public class kart extends AppCompatButton{
    boolean acikMi = false;
    boolean cevrilebilir = true;

    int arkaPlanID;
    int onPlanID = 0;

    Drawable on;
    Drawable arka;
    public kart(Context context, int id) {
        super(context);
        setId(id);
        arkaPlanID = R.drawable.back;
        if(id%8==0)
            onPlanID = R.drawable.ic8;
        if(id%8==1)
            onPlanID = R.drawable.ic1;
        if(id%8==2)
            onPlanID = R.drawable.ic2;
        if(id%8==3)
            onPlanID = R.drawable.ic3;
        if(id%8==4)
            onPlanID = R.drawable.ic4;
        if(id%8==5)
            onPlanID = R.drawable.ic5;
        if(id%8==6)
            onPlanID = R.drawable.ic6;
        if(id%8==7)
            onPlanID = R.drawable.ic7;

        on = context.getResources().getDrawable(onPlanID);
        arka = context.getResources().getDrawable(arkaPlanID);
        // @SuppressLint("RestrictedApi") Drawable arka = AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        //@SuppressLint("RestrictedApi") Drawable on = AppCompatDrawableManager.get().getDrawable(context,onPlanID);

        setBackground(arka);
    }

    public void cevir(){
        if(cevrilebilir){
            if(!acikMi){
                setBackground(on);
                acikMi=true;
            }
            else {
                setBackground(arka);
                acikMi = false;
            }
        }

    }
}
