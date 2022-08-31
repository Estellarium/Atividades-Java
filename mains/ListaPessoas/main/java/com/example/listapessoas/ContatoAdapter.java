package com.example.listapessoas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.MyViewHolder>{

    private List<Contato> contatos;

    public ContatoAdapter(List<Contato> lista) {this.contatos = lista;}

        @NonNull
        @Override
        public MyViewHolder OnCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.contatos_adapter_view, parent, false);

            return new MyViewHolder(itemLista);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.txtNome.setText(this.contatos.get(position).getNome());
            holder.txtTele.setText(this.contatos.get(position).getMail());
            holder.txtMail.setText(this.contatos.get(position).getTele());
        }

        @Override
        public int getItemCount() {return this.contatos.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNome, txtTele, txtMail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtTele = itemView.findViewById(R.id.txtTele);
            txtMail = itemView.findViewById(R.id.txtMail);
        }
    }
}
