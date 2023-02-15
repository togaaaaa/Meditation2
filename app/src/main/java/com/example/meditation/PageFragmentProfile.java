package com.example.meditation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PageFragmentProfile extends Fragment {

    public PageFragmentProfile() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.back, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public final String[] image_titles = {
            "11:00",
            "15:55",
            "19:11",
            "11:11"
    };

    public static final Integer[] image_ids = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
    };

    public class CreateList {

        private String image_title;
        private Integer image_id;

        public String getImage_title() {
            return image_title;
        }

        public void setImage_title(String android_version_name) {
            this.image_title = android_version_name;
        }

        public Integer getImage_ID() {
            return image_id;
        }

        public void setImage_ID(Integer android_image_url) {
            this.image_id = android_image_url;
        }
    }
    private ArrayList<CreateList> prepareData() {

        ArrayList<CreateList> theimage = new ArrayList<>();
        for(int i = 0; i< image_titles.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_ID(image_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }


}
