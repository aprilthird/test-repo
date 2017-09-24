package pe.edu.upc.cacthuppc1.adapters;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FrameMetricsAggregator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import org.w3c.dom.Text;

import java.util.List;

import pe.edu.upc.cacthuppc1.R;
import pe.edu.upc.cacthuppc1.activities.MainActivity;
import pe.edu.upc.cacthuppc1.models.Source;

/**
 * Created by Usuario on 21/09/2017.
 */

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.ViewHolder> {
    private List<Source> sources;

    public SourcesAdapter() {
    }

    public SourcesAdapter(List<Source> sources) {
        this.setSources(sources);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.card_sources, parent, false
                        ));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Source source = sources.get(position);

        holder.logoANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setImageUrl(source.getUrlToLogo());
        holder.nameTextView.setText(source.getName());
        holder.aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //TODO

                view.getContext().startActivity(new Intent(view.getContext(), AboutSourceActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        holder.newsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //TODO
            }
        });
    }

    @Override
    public int getItemCount() {
        return getSources().size();
    }

    public List<Source> getSources() {
        return sources;
    }

    public SourcesAdapter setSources(List<Source> sources) {
        this.sources = sources;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView logoANImageView;
        TextView nameTextView;
        TextView aboutTextView;
        TextView newsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            logoANImageView = (ANImageView) itemView.findViewById(R.id.logoANImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            aboutTextView = (TextView) itemView.findViewById(R.id.aboutTextView);
            newsTextView = (TextView) itemView.findViewById(R.id.newTextView);
        }
    }
}
