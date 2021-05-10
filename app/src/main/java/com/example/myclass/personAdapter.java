    package com.example.myclass;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class personAdapter extends FirebaseRecyclerAdapter<
        DataModal, personAdapter.personsViewholder> {

    public personAdapter(
            @NonNull FirebaseRecyclerOptions<DataModal> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull DataModal model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.Name.setText(model.getName());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.RegisterNo.setText(model.getRegisterNo());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        int x=model.getCount();
        if(x%2==0){
            holder.count.setText("Absent");
        }
        else {
            holder.count.setText("Present");
        }
        holder.date.setText(String.valueOf(model.getDate()));
        holder.classandsec.setText(String.valueOf(model.getClassandSec()));
        //holder.count.setText(String.valueOf(model.getCount()));
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listview, parent, false);
        return new personAdapter.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView Name, RegisterNo, date, count,classandsec;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            Name
                    = itemView.findViewById(R.id.Name);
            RegisterNo = itemView.findViewById(R.id.RegisterNo);
            classandsec = itemView.findViewById(R.id.classsec);
            date = itemView.findViewById(R.id.date);
            count= itemView.findViewById(R.id.status);
        }
    }
}
