package com.appENEM.menugrupal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Attr;

import java.util.zip.Inflater;

public class MainActivity extends FragmentActivity {

    LinearLayout conteiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setContentView(R.layout.activity_mascara_menu);
        TextView txtCht = (TextView) findViewById(R.id.txtCHT);
        click(txtCht);

        TextView txtCnt = (TextView) findViewById(R.id.txtCNT);
        click(txtCnt);
        TextView txtLct = (TextView) findViewById(R.id.txtLCT);
        click(txtLct);
        TextView txtMt = (TextView) findViewById(R.id.txtMT);
        click(txtMt);
    }

    public void click(final TextView tv){
        final TextView tx = new TextView(this);

        final ViewGroup vg = new ViewGroup(this) {
            @Override
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                LinearLayout ll = MainActivity.this.findViewById(R.id.linearFragment);
                ll.layout(l, t,r, b);
                tx.setText("Estou aqui");
                ll.addView(tx);

            }
        };


        final LayoutInflater inflater = new LayoutInflater(this) {
            @Override
            public LayoutInflater cloneInContext(Context newContext) {
                return null;
            }
        };

        inflater.inflate(R.layout.activity_fragment_maen, vg);


        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar =
                        Snackbar.make(tv, "Vamos estudar:"
                                + tv.getText(), Snackbar.LENGTH_INDEFINITE );
                snackbar.setActionTextColor(
                        getResources()
                                .getColor(R.color.menuFundo));

                    snackbar.show();
                   /* Gerenciador_fragment gf = (Gerenciador_fragment)
                            getSupportFragmentManager()
                                    .findFragmentById(R.id.fraAlternGeral);*/

                Gerenciador_fragment gf = new Gerenciador_fragment();
                            gf.onCreateView(
                                   inflater.cloneInContext(vg.getContext()) ,
                                    vg, Bundle.EMPTY);
                            gf.onAttach(this);
                            gf.onStart();
                            gf.onViewCreated(vg,Bundle.EMPTY);
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
