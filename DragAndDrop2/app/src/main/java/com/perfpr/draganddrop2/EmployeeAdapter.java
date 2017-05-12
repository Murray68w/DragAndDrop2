package com.perfpr.draganddrop2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private final List<Employee> mEmployee;
    public LinearLayout timesLayout;
    private boolean isVisibile;

    EmployeeAdapter(List<Employee> mEmployee) {this.mEmployee = mEmployee;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_employee_name_list, parent, false);
        return new EmployeeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Employee employee = mEmployee.get(position);
        holder.tvName.setText(employee.getmEmployeeName());
        holder.toggleTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isVisibile) {
                    timesLayout.setVisibility(View.VISIBLE);
                    isVisibile = true;
                    //hidden
                } else {
                    timesLayout.setVisibility(View.INVISIBLE);
                    isVisibile = false;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mEmployee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageButton toggleTimes, move;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvEmployeeName);
            toggleTimes = (ImageButton) itemView.findViewById(R.id.ib_expand_times);
            move = (ImageButton) itemView.findViewById(R.id.ib_drag_name);
            timesLayout = (LinearLayout) itemView.findViewById(R.id.layout_times);
        }

    }


}
