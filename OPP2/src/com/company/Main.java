package com.company;

public class Main {

    public static void main(String[] args) {
	    //System.out.println("HEllo");
	    Matrix first=new Matrix(3,4);
	    Matrix second=new Matrix(3,4);
	    first.Filling();
	    second.Filling();
        first.Show();
	    first.Sum(second);
        first.Show();

    }
}
