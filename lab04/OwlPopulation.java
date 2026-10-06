// CSCI 1933 Lab 04

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner s = new Scanner(f);

        int numLines = 0;
        while(s.hasNextLine()){
            numLines++;
            String str = s.nextLine();
        }
        s.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs

        // TODO: Populate the data with owls constructed from the lines of the file given
        // (Helpful hints can be found in the write up)
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        //TODO: Populate the class variables in OwlPopulation
    }

    public double averageAge(){
        //TODO: implement
        return -1;
    }

    public Owl getYoungest(){
        //TODO: implement
        return null;
    }

    public Owl getHeaviest(){
        //TODO: implement
        return null;
    }

    public String toString(){
        //TODO: implement
        return null;
    }

    public boolean containsOwl(Owl other){
        //TODO: method you can implement as a helper function to your merge method
        return false;
    }
	
    public void merge(OwlPopulation other){
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.

        //2) make a new data array to hold the correct number of owls for the merged population

        //3) copy over the distinct owls from each population to the data array

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
    }

    public int popSize(){
        return data.length;
    }
	
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");

	    // Milestone 2:
	    System.out.println(pop1.popSize());
	    System.out.println(pop2.popSize());

	    // Milestone 3: Comment these lines back in
	    // System.out.println(pop1);
	    // System.out.println(pop2);

            // Milestone 4: Comment these lines back in
            // pop1.merge(pop2);
            // System.out.println(pop1);
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
