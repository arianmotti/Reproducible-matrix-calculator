import java.util.Scanner;

public class Matrix {
    private int row;
    private int column;
    private int matrix[][];


    public Matrix(int rows, int columns) {
        this.row = rows;
        this.column = columns;
        this.matrix = new int[row][column];


    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setValue(int row, int column, int value) {
        matrix[row][column] = value;


    }

    public int getValue(int row, int column) {
        return matrix[row][column];
    }

    public Matrix multiply(Matrix m) {
        if (this.column == m.row) {
            Matrix product = new Matrix(this.row, m.column);
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < m.column; j++) {
                    for (int k = 0; k < m.row; k++) {
                        product.setValue(i, j, product.getValue(i, j) + this.getValue(i, k) * m.getValue(k, j));
                    }
                }
            }


            return product;


        } else {
            return null;
        }

    }

    public Matrix add(Matrix m) {
        if (m.row == this.row && m.column == this.column) {
            Matrix tmp = new Matrix(row, column);
            for (int c = 0; c < row; c++)
                for (int d = 0; d < column; d++)
                    tmp.setValue(c, d, (this.getValue(c, d) + m.getValue(c, d)));

            return tmp;
        } else {
            return null;
        }

    }

    public Matrix subtract(Matrix m) {
        if (m.row == this.row && m.column == this.column) {
            Matrix tmp = new Matrix(row, column);
            for (int c = 0; c < row; c++)
                for (int d = 0; d < column; d++)
                    tmp.setValue(c, d, this.getValue(c, d) -m.getValue(c, d));

            return tmp;
        } else {
            return null;

        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n==0)
            return;

        int r = in.nextInt();
        int c = in.nextInt();
        Matrix m1 = new Matrix(r, c);
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                m1.setValue(i, j, in.nextInt());


        int r2 = in.nextInt();
        int c2 = in.nextInt();
        Matrix m2 = new Matrix(r2, c2);
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                m2.setValue(i, j, in.nextInt());


        char x = in.next().charAt(0);
        if (x== '+') {
            for (int i = 0; i < n; i++) {
                if (m1 == null) {
                    break;
                }
                m1 = m1.add(m2);
            }
        }
        if (x == '-') {
            for (int i = 0; i < n; i++) {
                if (m1 == null) {
                    break;
                }
                m1 = m1.subtract(m2);
            }
        }
        if (x == '*') {
            for (int i = 0; i < n; i++) {
                if (m1 == null) {
                    break;
                }
                m1 = m1.multiply(m2);
            }
        }
        if (m1 != null)
            for (int i = 0; i < m1.getRow(); i++) {
                for (int j = 0; j < m1.getColumn(); j++) {
                    System.out.print(m1.getValue(i, j) + " ");
                }
                System.out.println();
            }
        else
            System.out.println("ERROR");
    }


}



