package com.perfpr.draganddrop2;

import android.content.ClipData;
import android.net.sip.SipAudioCall;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perfpr.draganddrop2.dummy.DummyContent.DummyItem;

import java.util.List;


public class JobQueAdapter extends RecyclerView.Adapter<JobQueAdapter
        .ViewHolder> {

    private final List<Job> mValues;
    SipAudioCall.Listener mListener;


    public JobQueAdapter(List<Job> jobQue) {
        mValues = jobQue;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_job_que, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Job jobQue = mValues.get(position);
        holder.mCustomerName.setText(jobQue.getmCustomerName());
        holder.mJobDate.setText(jobQue.getmDate());
        holder.mJobType.setText(jobQue.getmType());
        holder.cvJobs.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(data, shadowBuilder, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        holder.cvJobs.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public List<Job> getCustomList() {
        return mValues;
    }

    public interface Listener {
        void setEmptyList(boolean visibility);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView mCustomerName;
        public TextView mJobType;
        public TextView mJobDate;
        public TextView mContentView;
        public CardView cvJobs;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            cvJobs = (CardView) view.findViewById(R.id.cv_job);
            mCustomerName = (TextView) view.findViewById(R.id.tvCustomerName);
            mJobDate = (TextView) view.findViewById(R.id.tvJobDate);
            mJobType = (TextView) view.findViewById(R.id.tvJobType);
        }


        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
