package com.sachin.dmilf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.sachin.dmilf.R;

public class OnboardingAdapter extends PagerAdapter {

    private final Context context;
    private final String[] titles;
    private final String[] subtitles;

    int images[] = {
            R.drawable.bg_1,
            R.drawable.bg_2,
            R.drawable.bg_3
    };

    public OnboardingAdapter(@NonNull Context context) {
        this.context = context;

        titles = new String[]{
                context.getString(R.string.welcome_to_dmilf),
                context.getString(R.string.track_analyze_improve),
                context.getString(R.string.build_better_money_habits)
        };

        subtitles = new String[]{
                context.getString(R.string.subtitle1),
                context.getString(R.string.subtitle2),
                context.getString(R.string.subtitle3)
        };
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.slide, container, false);

        ImageView image = view.findViewById(R.id.slideImg);
        TextView title = view.findViewById(R.id.sliderTitle);
        TextView subtitle = view.findViewById(R.id.sliderSubTitle);

        image.setImageResource(images[position]);
        title.setText(titles[position]);
        subtitle.setText(subtitles[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
