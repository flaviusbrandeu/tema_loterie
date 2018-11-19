import java.io.*;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Loterie
{
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter outputStream=new BufferedWriter(new OutputStreamWriter("ultimele_extrageri.txt"));
    Random rand=new Random();
    public int[] readNumbers(int n)
    {
        int[] numere_jucate=new int[n];
        if(n==5)
            System.out.println("Introduceti 5 numere cuprinse intr 1 si 40,reprezentand biletul pe care vreti sa il jucati;\nDupa fiecare numar apasati Enter!");
        else if(n==6)
            System.out.println("Introduceti 6 numere cuprinse intr 1 si 49,reprezentand biletul pe care vreti sa il jucati;\nDupa fiecare numar apasati Enter!");
        for(int i=0;i<n;i++)
        {
            try
            {
                numere_jucate[i] = Integer.parseInt(reader.readLine());
                if(n==5)
                {
                    if (numere_jucate[i] < 1 || numere_jucate[i] > 40)
                        throw new NumarInvalid();
                }
                else if(n==6)
                {
                    if (numere_jucate[i] < 1 || numere_jucate[i] > 49||contains(i,numere_jucate[i],numere_jucate))
                        throw new NumarInvalid();
                }

            }
            catch (NumberFormatException e)
            {
                    System.out.println("Ati introdus altceva decat un numar!\nIntroduceti strict numere!!!");
                    i--;
            }
            catch (NumarInvalid e)
            {
                System.out.println("Ati introdus un numar ce nu corespunde biletului pe care ati ales sa il jucati sau ati mai introdus acest numar!\nIntroduceti alt numar");
                i--;
            }
            catch (Exception e)
            {
                    System.err.println("S-a generat o exceptie!!");
            }
        }

        return numere_jucate;
    }
    public boolean contains(int poz,int numar,int[] curArray)
    {
        for(int i=0;i<poz;i++)
        {
            if (curArray[i] == numar)
                return true;
        }
        return false;
    }


    public int[] generateNRandomNumbers(int n,int min,int max)
    {
        int currentNumber;
        int[] numbers=new int[n];
        for(int i=0;i<n;i++)
        {
            currentNumber=rand.nextInt(max)+min;
            if(contains(i,currentNumber,numbers))
            {
                i--;
                generateNRandomNumbers(n,min,max);
            }
            else numbers[i]=currentNumber;
        }
        return numbers;
    }
    public int getCommonNumbersCount(int[] numbers,int[] numbers1)
    {
        int i,count=0;
        for(i=0;i<numbers.length;i++)
        {
            if (contains(numbers1.length,numbers[i], numbers1))
                count++;
        }
        return count;
    }
    public int[] getCommonNumbers(int[] numbers,int [] numbers1)
    {
        int count=-1;
        int[] commonNumbers=new int[getCommonNumbersCount(numbers,numbers1)];
        for(int i=0;i<numbers.length;i++)
        {
            if(contains(numbers1.length,numbers[i], numbers1))
            {
                count++;
                commonNumbers[count]=numbers[i];
            }
        }
        return commonNumbers;
    }
}

