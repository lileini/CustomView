package com.example.litao.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_Span)
    EditText etSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        SpannableString span = new SpannableString("风萧萧兮易水寒，壮士一去兮不复还。");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);//设置字体颜色
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.BLUE);//设置背景颜色
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(30);//设置尺寸
//        android.text.style 所有的span都出至这个包中
        span.setSpan(absoluteSizeSpan, 1, 3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        etSpan.setText(span);
    }
}
