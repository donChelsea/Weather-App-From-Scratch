package com.example.weatherappfromscratch.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherappfromscratch.R;
import com.example.weatherappfromscratch.model.Weather;
import com.squareup.picasso.Picasso;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private TextView dayTextView;
    private TextView highTextView;
    private TextView lowTextView;
    private ImageView imageView;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        dayTextView = itemView.findViewById(R.id.day_textview);
        highTextView = itemView.findViewById(R.id.high_textview);
        lowTextView = itemView.findViewById(R.id.low_textview);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void onBind(Weather weather, int icon) {
        String[] weatherDate = weather.getDateTimeISO().split("T");
        dayTextView.setText(weatherDate[0]);
        highTextView.setText(weather.getMaxTempF() + "F");
        lowTextView.setText(weather.getMinTempF() + "F");
        Picasso.get()
                .load(icon)
                .into(imageView);
    }

}
