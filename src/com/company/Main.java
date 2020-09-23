package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Console;
import java.util.Random;

class Int {
    int i = 1;
    int j = 2;

    public int get_i(){
        return i;
    }
    public void set_i(int new_i){
        this.i = new_i;
    }

    public Int(){}
    public Int(int i){
        this.i = i;
    }
    public Int(int i, int j){
        this.i = i;
        this.j = j;
    }
    public void display(){
        System.out.println(this.i);
    }
}

public class Main {
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("début du jeu, appuyer sur x pour partir, sur entré pour continuer");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a = null;
            try {
                a = reader.readLine();
                if (a.equals("x"))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Entre un nombre entre 1 et 100 (x pour quitter)");
            int hidden_number = getRandomNumberInRange(0, 100);
            int user_number;
            while (true) {
                try {
                    user_number = Integer.parseInt(reader.readLine());
                    if (user_number > 100 || user_number < 0){
                        System.out.println("mauvais nombre, recommence");
                        continue;
                    }
                    if (user_number < hidden_number)
                        System.out.println("c'est plus");
                    else if (user_number > hidden_number)
                        System.out.println("c'est moins");
                    else {
                        System.out.println("Gagné !");
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Erreur : autre chose qu'un nombre à été mis, recommence");
                    e.printStackTrace();
                }

            }
            System.out.println(a);

        }



    }

}
