package com.example.pruebaexamen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Asegúrate de que la clase LandscapeItem esté correctamente definida en tu proyecto
public class LandscapeItemAdapter extends RecyclerView.Adapter<LandscapeItemAdapter.ViewHolder> {

    private List<LandscapeItem> landscapeItems;
    private Context context;

    public LandscapeItemAdapter(Context context, List<LandscapeItem> landscapeItems) {
        this.context = context;
        this.landscapeItems = landscapeItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.landscape_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LandscapeItem item = landscapeItems.get(position);
        holder.imageView.setImageResource(item.getImageResourceId()); // Carga la imagen usando el ID del recurso
        holder.nameOverlay.setText(item.getName());
        holder.btnCancel.setOnClickListener(v -> {
            removeItem(position);
        });
        // Añade también el listener para el botón accept si es necesario
    }

    @Override
    public int getItemCount() {
        return landscapeItems.size();
    }

    private void removeItem(int position) {
        landscapeItems.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameOverlay;
        Button btnCancel;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            nameOverlay = itemView.findViewById(R.id.text_overlay);
            btnCancel = itemView.findViewById(R.id.button_cancel);
        }
    }
}
