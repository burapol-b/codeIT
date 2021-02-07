package com.coe.project.codeit.CodingPage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coe.project.codeit.R;

public class ShowProjectFragment extends DragdropActionListener  {
    //private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textView;
    private Button button;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    private static final String IMAGE_VIEW_TAG = "LAUNCHER LOGO";
    private static final String TEXT_VIEW_TAG = "DRAG TEXT";
    private static final String BUTTON_VIEW_TAG = "DRAG BUTTON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.table_layout); //layout showproject_fragment
        findViews();
        implementEvents();
    }

    private void findViews() {
        /*
        imageView1 = (ImageView) findViewById(R.id.img1); //btn 1
        imageView1.setTag(IMAGE_VIEW_TAG + "1");

        imageView2 = (ImageView) findViewById(R.id.img2); //btn2
        imageView2.setTag(IMAGE_VIEW_TAG + "2");

        imageView3 = (ImageView) findViewById(R.id.img3); //btn3
        imageView3.setTag(IMAGE_VIEW_TAG + "3");
        */
    }

    private void implementEvents() {
        /*
        //add or remove any view that you don't want to be dragged
        imageView1.setOnLongClickListener(this);
        imageView2.setOnLongClickListener(this);
        imageView3.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.left1_layout).setOnDragListener(this);
        findViewById(R.id.right1_layout).setOnDragListener(this);
        findViewById(R.id.left2_layout).setOnDragListener(this);
        findViewById(R.id.right2_layout).setOnDragListener(this);
        */
    }
}
