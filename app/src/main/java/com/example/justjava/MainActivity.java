package com.example.justjava;

import android.os.Bundle;
//import android.support.v4.app.*;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    static int quantity = 1;
    static String priceMessage = "Free!";
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = 5;
        display(quantity);
        if(quantity <= 0) priceMessage = "Free!";
        else priceMessage = "Thanks for the order!";
        displayPrice(quantity * price, priceMessage);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number, String priceMessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        displayMessage(priceMessage);
    }

    public void increment(View view){
        quantity++;
        display(quantity);
    }

    public void decrement(View view){
        if(quantity <= 0) quantity = 0;
        else quantity--;

        display(quantity);
    }

    public void resetValue(View view){
        quantity = 0;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view2);
        priceTextView.setText(message);
    }
}