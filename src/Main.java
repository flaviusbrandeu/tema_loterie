public class Main
{

    public static void main(String[] args)
    {
        Loterie l=new Loterie();

        int bilet[]=new int[6];
        int extragere[]=new int[6];
        int commonNumbersCount;
        bilet=l.readNumbers(6);
        System.out.println("Numere jucate pe bilet:");
        for(int numar:bilet)
            System.out.print(numar+" ");
        extragere=l.generateNRandomNumbers(6,1,49);
        System.out.println("\nNumere extrase:");
        for(int numar:extragere)
            System.out.print(numar+" ");
        commonNumbersCount=l.getCommonNumbersCount(bilet,extragere);
        if(commonNumbersCount==0)
            System.out.println("\nNu ati nimerit niciun numar :)\nMai incercati!");
        else
        {
            System.out.println("\nAti nimerit "+commonNumbersCount+" numar,anume:");
           for(int numar:l.getCommonNumbers(bilet,extragere))
               System.out.println(numar+" ");
        }

    }
}
