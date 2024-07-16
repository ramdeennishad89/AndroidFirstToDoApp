package com.example.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {
    public static final String FILENAME = "listinfo.dat";

    public static void writeData(ArrayList<String> items, Context context) throws IOException {

        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oas = new ObjectOutputStream(fos);
            oas.writeObject(items);
            oas.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
        public  static  ArrayList<String> readData(Context context)
        {
            ArrayList<String> itemList=null;
            try {
                FileInputStream fis=context.openFileInput(FILENAME);
                ObjectInputStream ois=new ObjectInputStream(fis);
                itemList = (ArrayList<String>) ois.readObject();
            } catch (Exception e) {
                itemList = new ArrayList<>();
            }

            return itemList;


}}
