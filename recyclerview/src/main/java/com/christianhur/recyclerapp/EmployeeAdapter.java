package com.christianhur.recyclerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.christianhur.recyclerapp.models.Employee;

import org.w3c.dom.Text;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{

    private Employee[] employeeList = Employee.employeeList;
    //private int[] imgResources = Employee.imgResources;
    private Listener listener;

    interface Listener{
        void onClickedEmployee(int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull  EmployeeAdapter.ViewHolder holder, int position) {
//        holder.getImg_Avatar().setImageResource(imgResources[position]);
        holder.getImg_Avatar().setImageResource(employeeList[position].getImgResource());
        holder.getTxt_name().setText(employeeList[position].getName());
        holder.getTxt_title().setText(employeeList[position].getTitle());

//        holder.getCardView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO
//            }
//        });

        CardView cardView = holder.getCardView();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tight Coupling
//                Intent intent = new Intent(v.getContext(),EmployeeActivity.class);
//                intent.putExtra("EE_id",position);
//                Context context = v.getContext();
//                context.startActivity(intent);

               // v.getContext().startActivity(intent);

                //Loose Coupling -- use interface
                listener.onClickedEmployee(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return employeeList.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    /** INNER CLASS *******************************************************************/
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_Avatar;
        private TextView txt_name;
        private TextView txt_title;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img_Avatar = (ImageView) itemView.findViewById(R.id.img_avatar);
            this.txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            this.txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            this.cardView = (CardView) itemView;
        }

        public ImageView getImg_Avatar() {
            return img_Avatar;
        }

        public TextView getTxt_name() {
            return txt_name;
        }

        public TextView getTxt_title() {
            return txt_title;
        }

        public CardView getCardView() {
            return cardView;
        }
    }

}
