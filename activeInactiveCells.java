package com.example;

public class activeInactiveCells {
    public static void activeInactive(boolean[] cells, int n, int k)
    {
        boolean temp[] = new boolean[n];
        for (int i=0; i<n; i++)
        {
            temp[i] = cells[i];
        }

        while(k-- > 0)
        {
            //find values of edges
            temp[0] = false^cells[1];
            temp[n-1] = false^cells[n-2];

            //compute internal cells
            for(int i=1; i<n-2; i++)
            {
                temp[i] = cells[i-1] ^ cells[i+1];
            }

            //copy temp into cells for the next day
            for(int i=0; i<n; i++)
                cells[i] = temp[i];
        }

        int active =0;
        int inactive =0;
        for(int i=0; i<n; i++)
        {
            if(cells[i] == true)
                active++;
            else
                inactive++;
        }
        System.out.println("Active Cells: " + active + "\n Inactive Cells: " + inactive);

    }

    public static void main(String[] args) {
        boolean cells[] = {false, true, false, true,false, true, false, true};
        int n = cells.length;
        int k=3;
        activeInactive(cells,n,k);
    }
}
