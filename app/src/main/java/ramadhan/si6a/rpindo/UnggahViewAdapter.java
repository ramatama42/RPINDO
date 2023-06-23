package ramadhan.si6a.rpindo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ramadhan.si6a.rpindo.databinding.ItemUnggahBinding;

public class UnggahViewAdapter {
    private List<Unggah> data = new ArrayList<>();
    private onItemLongClickListener onItemLongClickListener;

    public void setData(List<Unggah> data){
        this.data = data;
        notifyDataSetChanged();
    }


    public void setOnItemLongClickListener(UnggahViewAdapter.onItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public UnggahViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemUnggahBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UnggahViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Unggah unggah = data.get(pos);
        holder.itemUnggahBinding.tvNamakota.setText(unggah.getNamaevent());
        holder.itemUnggahBinding.tvJenis.setText(unggah.getAlamat());
        holder.itemUnggahBinding.tvDeskripsi.setText(unggah.getDeskripsi());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v,unggah,pos);
                return false;
            }
        });
    }

    private static void onItemLongClick(View v, Unggah unggah, int pos) {
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUnggahBinding itemUnggahBinding;
        public ViewHolder(@NonNull ItemUnggahBinding itemView) {
            super(itemView.getRoot());
            itemUnggahBinding = itemView;
        }
    }

    public interface onItemLongClickListener{
        void onItemLongClick(View v, Unggah unggah, int position);
    }
}
