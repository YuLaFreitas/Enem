package com.appENEM.menugrupal;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JavascriptInterface;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Resposta {
    private Context context;
    Resposta(Context x){
        context = x;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @JavascriptInterface
    public void comentario(String texto){
        AlertDialog.Builder adl = new AlertDialog.Builder(context);
        final TextView tx = new TextView(context);

        tx.setTextColor(Color.BLUE);
        tx.setText(texto);
        tx.setVerticalScrollBarEnabled(true);
        tx.onScreenStateChanged(ScrollView.SCROLLBAR_POSITION_LEFT);
        tx.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tx.setFreezesText(true);
        tx.setMovementMethod(new ScrollingMovementMethod());

        adl.setView(tx);
        adl.setNegativeButton("ENTENDEU???",null);
    adl.create().show();
    }
}
