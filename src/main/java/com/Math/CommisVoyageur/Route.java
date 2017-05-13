package com.Math.CommisVoyageur;

import java.util.*;

/**
 * Created by Ichanskiy on 2017-05-06.
 */
public class Route
{
    private int numberOfNodes;
    private Stack<Integer> stack;

    public Route()
    {
        stack = new Stack<Integer>();
    }

    public List<Integer> tsp(double adjacencyMatrix[][])
    {
        List<Integer> dstList = new ArrayList<Integer>();
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        double min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");
        dstList.add(1);

        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                dstList.add(dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return dstList;
    }

}
