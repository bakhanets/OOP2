package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import java.text.DecimalFormat;
import java.util.Random;
//переделать умножение матриц
public class Matrix {
    private double [][] matrix;
    private int size_1;
    private int size_2;

    public double[][] getMatrix() {
        return matrix;
    }
    public Matrix(int size){ // Конструктор для квадратной матрицы
        this.size_1=size;
        this.size_2=size;
        this.matrix=new double[size][size];
        Filling();
    }
    public Matrix(int size_1,int size_2){ // Конструктор для прямоугольной матрицы
        this.size_1=size_1;
        this.size_2=size_2;
        this.matrix=new double[size_1][size_2];
        Filling();
    }
    public void Filling(){ //заполняет матрциу элементами
        Random r=new Random();
        for (int i=0;i<size_1;i++){
            for(int j=0;j<size_2;j++){
                this.matrix[i][j]=r.nextDouble();
            }
        }
    }
    public void Show(){
        for (int i=0;i<size_1;i++){
            for(int j=0;j<size_2;j++){
                DecimalFormat df=new DecimalFormat("#.#");
                System.out.print(df.format(matrix[i][j]));
                System.out.print("\t\t");
            }
            System.out.println();
        }

    }
    static public void CheckSize(Matrix A,Matrix B){// Проверяет одинакого ли размера матрицы
        if (A.size_1!=B.size_1||A.size_2!=B.size_2){
            throw new ValueException("Матрицы разного размера");
        }
    }
    static public Matrix Сopy(Matrix A,Matrix B){ //Копирование матрица имеется вопрос!!!!
        CheckSize(A,B);
        A=B;
        return A;
    }
    public void Sum(Matrix B){// Сумма матрица
        CheckSize(this,B);

        for (int i=0;i<this.size_1;i++){
            for(int j=0;j<this.size_2;j++){
                this.matrix[i][j]+=B.matrix[i][j];
            }
        }
    }
     public void Difference(Matrix B){//разность матриц
        CheckSize(this,B);

        for (int i=0;i<this.size_1;i++){
            for(int j=0;j<this.size_2;j++){
                this.matrix[i][j]-=B.matrix[i][j];
            }
        }
    }
    public void Multiplication(Matrix B){ // умножение матрицы на другую(результат записываем в первую)
        CheckSize(this,B);

        for (int i=0;i<this.size_1;i++){
            for(int j=0;j<this.size_2;j++){
                this.matrix[i][j]*=B.matrix[i][j];
            }
        }
    }
    public void Multiplication(int k){// умножение матрица на скаляр
        for (int i=0;i<size_1;i++){
            for(int j=0;j<size_2;j++){
                this.matrix[i][j]*=k;
            }
        }
    }
    public double Min(){// поиск минимального
        double min=matrix[0][0];
        for (int i=0;i<size_1;i++){
            for(int j=0;j<size_2;j++){
                if (min>matrix[i][j]){
                    min=matrix[i][j];
                }
            }
        }
        return min;
    }
    public double Max(){ // поиск максимального
        double max=matrix[0][0];
        for (int i=0;i<size_1;i++){
            for(int j=0;j<size_2;j++){
                if (max<matrix[i][j]){
                    max=matrix[i][j];
                }
            }
        }
        return max;
    }
    static public Matrix Sum(Matrix A,Matrix B){// Сумма матриц
        CheckSize(A,B);
        Matrix C=new Matrix(A.size_1,A.size_2);

        for (int i=0;i<C.size_1;i++){
            for(int j=0;j<C.size_2;j++){
               C.matrix[i][j]=A.matrix[i][j]+B.matrix[i][j];
            }
        }
        return C;
    }
    static public Matrix Difference(Matrix A,Matrix B){// РАзность матриц
        CheckSize(A,B);
        Matrix C=new Matrix(A.size_1,A.size_2);

        for (int i=0;i<C.size_1;i++){
            for(int j=0;j<C.size_2;j++){
                C.matrix[i][j]=A.matrix[i][j]-B.matrix[i][j];
            }
        }
        return C;
    }
    static public Matrix Multiplication(Matrix A,Matrix B){// умножение матриц
        CheckSize(A,B);
        Matrix C=new Matrix(A.size_1,A.size_2);

        for (int i=0;i<C.size_1;i++){
            for(int j=0;j<C.size_2;j++){
                C.matrix[i][j]=A.matrix[i][j]*B.matrix[i][j];
            }
        }
        return C;
    }
}
