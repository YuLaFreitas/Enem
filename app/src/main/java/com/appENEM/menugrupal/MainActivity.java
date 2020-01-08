package com.appENEM.menugrupal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends Activity {
    LinearLayout conteiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setContentView(R.layout.activity_mascara_menu);

       TextView txtCht = findViewById(R.id.txtCHT);
        click(txtCht, "humanas");
        TextView txtCnt = findViewById(R.id.txtCNT);
        click(txtCnt, "natureza");
        TextView txtLct = findViewById(R.id.txtLCT);
        click(txtLct,"linguagens");
        TextView txtMt =  findViewById(R.id.txtMT);
        click(txtMt, "numeros");
    }

    public void click(final TextView tv, final String grupo){

        final Intent in = new Intent(this, Gerenciador_arquivo.class);

        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               in.putExtra("grupo", grupo);
                startActivity(in);
            }
        });
        }

    //APRESENTA DETALHES, FUTURAMENTE PODE SER UM FILTRO POR MATERIAS
    public void onClick(View v){
        try {
            FloatingActionButton opcao = findViewById(v.getId());
            if (opcao.isSaveEnabled()) {
                opcao.animate().rotation(360).rotationXBy(180)
                        .setDuration(1000);
                switch (v.getId()) {
                    case R.id.flo_cht:
                        conteiner = findViewById(R.id.conteinerMenuCHT);
                        conteiner.addView(getDETALHES(R.string.chtDetalhes));
                        break;
                    case R.id.flo_cnt:
                        conteiner = findViewById(R.id.conteinerMenuCNT);
                        conteiner.addView(getDETALHES(R.string.cntDetalhes));
                        break;
                    case R.id.flo_lct:
                        conteiner = findViewById(R.id.conteinerMenuLCT);
                        conteiner.addView(getDETALHES(R.string.lctDetalhes));
                        break;
                    case R.id.flo_mt:
                        conteiner = findViewById(R.id.conteinerMenuMT);
                        conteiner.addView(getDETALHES(R.string.mtDetalhes));
                        break;
                }
                opcao.setSaveEnabled(false);
            } else {
                v.animate().rotation(360).rotationXBy(180)
                        .setDuration(1000);
                conteiner.removeViews(1, 1);
                opcao.setBackgroundColor(getResources().getColor(R.color.menuFundo));

                opcao.setSaveEnabled(true);
            }
        }catch (Exception e){
            CharSequence charSequence= e.getMessage() + "\n" + e.getCause();
            Snackbar snackbar = Snackbar.make(v, charSequence, Snackbar.LENGTH_SHORT);
            snackbar.show();
            snackbar.setAction("ACTION", new OnClickListener() {
                @Override
                public void onClick(View v) {
               onResume();
                }
            });
        }
    }

    public View getDETALHES(int texto){

        final TextView txt = new TextView(this);

        txt.setText(getResources().getText(texto));

        txt.setGravity(Gravity.CENTER);
        txt.setTextColor(Color.WHITE);
        txt.setBackgroundColor(
                getResources().getColor(R.color.dethFundo)
        );
        txt.setTextSize(getResources().getDimensionPixelSize(R.dimen.fontDeth));
        txt.setAllCaps(true);

        return txt;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onResume();
    }

}
