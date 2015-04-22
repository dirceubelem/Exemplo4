package dirceubelem.exemplo4.task;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import dirceubelem.exemplo4.fw.Constants;
import dirceubelem.exemplo4.fw.Util;
import dirceubelem.exemplo4.to.TOBase;
import dirceubelem.exemplo4.to.TORede;

/**
 * Created by dirceubelem on 05/04/15.
 */
public class RedeTask extends AsyncTask<String, Void, TOBase> {

    @Override
    protected TOBase doInBackground(String... params) {

        TORede p = null;

        try {

            URL url = new URL(Constants.API.OBTER_REDE);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "text/plain; charset=utf-8");

            InputStream i = new BufferedInputStream(http.getInputStream());
            String result = Util.readString(i);
            p = TORede.createByJson(result, TORede.class);

        } catch (Exception e) {
            p = null;
        }

        return p;


    }
}
