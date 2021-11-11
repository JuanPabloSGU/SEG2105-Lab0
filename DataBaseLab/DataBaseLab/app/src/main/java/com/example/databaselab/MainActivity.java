package com.example.databaselab;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView idView;
    EditText productBox;
    EditText priceBox;

    ListView productList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set variables to the ids of .xml elements
        idView = (TextView) findViewById(R.id.productIDDisplay);
        productBox = (EditText) findViewById(R.id.productNameDisplay);
        priceBox = (EditText) findViewById(R.id.productPriceDisplay);
        productList = (ListView) findViewById(R.id.list_view);

        MyDBHandler dbHandler = new MyDBHandler(this);
        listItem = new ArrayList<>();

        //call the viewData() method to display the existing products

        viewData();

        // when a product in the list is clicked, a toast is displayed with the name of the product
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text = productList.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // we use onClick for the Add button in our layout to call this method
    public void newProduct(View view){

        if (productBox.getText().toString().trim().length() ==0 || priceBox.getText().toString().trim().length() == 0) {
            return;
        }
        MyDBHandler dbHandler = new MyDBHandler(this);

        // get price from the text box
        double price = Double.parseDouble(priceBox.getText().toString());

        // get product name from the text box
        // use the constructor from Product.java
        Product product = new Product(productBox.getText().toString(), price);

        // add to database with the addProduct() method from MyDBHandler.java
        dbHandler.addProduct(product);

        //clear the text boxes
        productBox.setText("");
        priceBox.setText("");

        // clearing the list of products
        // calling viewData() method to display the updated list of products
        // this means what is displayed in the ListView is always current
        listItem.clear();
        viewData();
    }

    // we use onClick for the delete button in our layout to call this method
    public void removeProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        // delete product in the database using deleteProduct() method from MyDBHandler.java
        boolean result = dbHandler.deleteProduct(productBox.getText().toString());

        // clearing the list of products
        // calling viewData() method to display the updated list of products
        // this emans what is displayed in the ListView is always current
        listItem.clear();
        viewData();

        // "Record Deleted" or "No Match Found"
        if(result) {
            idView.setText("Record Deleted");
            productBox.setText("");
            priceBox.setText("");
        }
        else
            idView.setText("No Match Found");
    }
    public void lookupProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);


        // get product in the database
        Product product = dbHandler.findProduct(productBox.getText().toString());

        if(product!=null){
            idView.setText(String.valueOf(product.getID()));
            priceBox.setText(String.valueOf(product.getPrice()));
        }

        else{
            idView.setText("No Match Found");
        }

    }
    private void viewData(){
        MyDBHandler dbHandler = new MyDBHandler(this);

        // call the viewData() method in MyDBHandler that runs the query
        Cursor cursor = dbHandler.viewData();

        // if there are no products in the table a toast says there is no data to show
        // otherwise, while there are products, keep moving to the next product
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Not data to show", Toast.LENGTH_SHORT).show();
        } else{
            while(cursor.moveToNext()){
                // I just want to display the product name so I only get column 1 from the table row
                listItem.add(cursor.getString(1));
            }
            // create an array adapter that provides a view for each item
            // simple_list_item_1 is a built-in xml layout from Android
            // I decided to use this instead of creating my own .xml file for items of the ListView
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);

            // attaching the adapter to the ListView
            productList.setAdapter(adapter);
        }
    }

}