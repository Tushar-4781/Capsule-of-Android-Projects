package com.example.javabased;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        if(quantity<100)
            quantity=quantity+1;
        else {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);

    }
    public void decrement(View view){
        if(quantity>1)
            quantity=quantity-1;
        else{
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);

    }
    /**
     * This method is called when the order button is clicked.
     */
    private int calculatePrice(boolean addWhippedCream, boolean chocolate){
        int price=5;
        if(addWhippedCream==true)
            price+=1;
        if(chocolate==true)
            price+=2;

        price = quantity*price;
        return price;
    }
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameEditText = (EditText) findViewById(R.id.name_edittext);

        String name = nameEditText.getText().toString();
        boolean chocolate =  chocolateCheckBox.isChecked();
        boolean addWhippedCream = whippedCreamCheckBox.isChecked();
        createOrderSummery(calculatePrice(addWhippedCream,chocolate),addWhippedCream,chocolate,name);
    }

    private void createOrderSummery(int price,boolean addWhippedCream, boolean chocolate,String name){
        String priceMessage = "Name: "+name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + chocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "JustJava Order");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given price on the screen.
     */

    /*private void displayPrice(int number){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(""+number);
    }*/

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



}