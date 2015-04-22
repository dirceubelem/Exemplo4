package dirceubelem.exemplo4;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;

import dirceubelem.exemplo4.adapter.RedeAdapter;
import dirceubelem.exemplo4.task.RedeTask;
import dirceubelem.exemplo4.to.TOBase;
import dirceubelem.exemplo4.to.TORede;


public class MainActivity extends ActionBarActivity {

    private ProgressDialog pd;
    private ListView listUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listUsuario = (ListView) findViewById(R.id.listAmigos);

        atualizaRede();

    }

    private void atualizaRede() {

        pd = new ProgressDialog(this);
        pd.setMessage("Carregando...");
        pd.show();

        RedeTask r = new RedeTask() {
            @Override
            protected void onPostExecute(TOBase to) {

                if(to != null) {

                    TORede t = (TORede) to;

                    RedeAdapter adapter = new RedeAdapter(t, MainActivity.this);
                    listUsuario.setAdapter(adapter);

                }

                pd.hide();

            }
        };

        r.execute("");

    }


}
