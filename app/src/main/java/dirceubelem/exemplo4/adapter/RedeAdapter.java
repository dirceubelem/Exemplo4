package dirceubelem.exemplo4.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import dirceubelem.exemplo4.R;
import dirceubelem.exemplo4.task.DownloadImagemTask;
import dirceubelem.exemplo4.to.TORede;
import dirceubelem.exemplo4.to.TOUsuario;

/**
 * Created by dirceubelem on 05/04/15.
 */
public class RedeAdapter extends BaseAdapter {

    private TORede rede;
    private Context context;

    public RedeAdapter(TORede rede, Context context) {
        this.rede = rede;
        this.context = context;
    }

    @Override
    public int getCount() {
        return rede.getLista().size();
    }

    @Override
    public Object getItem(int position) {
        return rede.getLista().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TOUsuario usuario = rede.getLista().get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.item_rede, null);

        final ImageView i = (ImageView) v.findViewById(R.id.avatar);

        DownloadImagemTask d = new DownloadImagemTask() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                i.setImageBitmap(bitmap);
            }
        };

        d.execute(usuario.getAvatar());

        TextView t = (TextView) v.findViewById(R.id.nome);
        t.setText(usuario.getUsuario());

        return v;
    }

}
