package com.perfpr.draganddrop2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.perfpr.draganddrop2.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p />
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TimeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private Spinner spinDate;
    private OnListFragmentInteractionListener mListener;
    private List<Employee> employeeList = new ArrayList<>();
    private List<Job> jobQue = new ArrayList<>();
    private JobQueAdapter jobAdapter;
    private EmployeeAdapter employeeAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TimeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TimeFragment newInstance(int columnCount) {
        TimeFragment fragment = new TimeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_list, container, false);
        //Setup JobDate spinner
        String dates[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
                "Sunday"};
        spinDate = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getContext(), android
                .R.layout.simple_spinner_item, dates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDate.setAdapter(adapter);
        //Setup JobQue RV
        RecyclerView rvJobs = (RecyclerView) view.findViewById(R.id.rvJobQue);
        jobAdapter = new JobQueAdapter(jobQue);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity(),
                LinearLayoutManager.VERTICAL, false);
        rvJobs.setLayoutManager(mLayoutManager);
        rvJobs.setItemAnimator(new DefaultItemAnimator());
        rvJobs.setAdapter(jobAdapter);
        //Setup Employee RV
        RecyclerView rvEmployees = (RecyclerView) view.findViewById(R.id.rvEmployeeList);
        employeeAdapter = new EmployeeAdapter(employeeList);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(this.getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        rvEmployees.setLayoutManager(mLayoutManager2);
        rvEmployees.setItemAnimator(new DefaultItemAnimator());
        rvEmployees.setAdapter(employeeAdapter);
        loadEmployeeValues();
        loadJobQueValues();

        return view;
    }

    private void loadEmployeeValues() {
        Employee newEmployee = new Employee("Graham");
        employeeList.add(newEmployee);
        newEmployee = new Employee("Seth");
        employeeList.add(newEmployee);
        newEmployee = new Employee("Mary");
        employeeList.add(newEmployee);
        newEmployee = new Employee("Dexter");
        employeeList.add(newEmployee);
        newEmployee = new Employee("Custom");
        employeeList.add(newEmployee);

    }

    private void loadJobQueValues() {
        Job newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
        newJob = new Job("id", "Customer Name", "Monday", "Walk", "Length");
        jobQue.add(newJob);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
