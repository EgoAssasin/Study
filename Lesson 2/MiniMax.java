import java.util.Random;

/**
 * Created by out-spiridonov-es on 06.12.2017.
 */
class Massiv {
    int[] mass;
    Massiv(int lenght) {mass=new int[lenght];}
}

class myRand {
    static int myNextInt(int N){
        Random random = new Random();
        return random.nextInt(N);
    }
}

class fulfill {
    static Massiv gen(byte razmer, int modul) {
        Massiv pole = new Massiv(razmer);
        for (byte i = 0; i < razmer; i++) {
            pole.mass[i] = myRand.myNextInt(2*(modul+1))-modul;
        }
        return pole;
    }
}

class exstremum {
    static byte maxNegative(Massiv m){
        byte k=0;
        for (byte i = 1; i < m.mass.length; i++) {
            if (m.mass[i]>=0) continue;
            if ((m.mass[k]>=0)&&(m.mass[i]<0)) k=i;
            if ((m.mass[i]<0)&&(m.mass[k]<m.mass[i])) k=i;
        }
        return k;
    }
    static byte minPositive(Massiv m){
        byte k=0;
        for (byte i = 1; i < m.mass.length; i++) {
            if (m.mass[i]<=0) continue;
            if ((m.mass[k]<=0)&&(m.mass[i]>=0)) k=i;
            if ((m.mass[i]>0)&&(m.mass[k]>m.mass[i])) k=i;
        }

        return k;
    }
}

class change{
    static  Massiv elements(Massiv m,byte i,byte j){
        int k=m.mass[i];
        m.mass[i]=m.mass[j];
        m.mass[j]=k;
        return m;
    }
}


public class MiniMax {
    public static void main(String args[]){
        byte k=20;
        int l=10;
        Massiv polemas = fulfill.gen(k,l);
        for (byte i = 0; i < k; i++) {
            System.out.print(polemas.mass[i]+" ");
        }
        byte n1=exstremum.maxNegative(polemas);
        byte n2=exstremum.minPositive(polemas);
        System.out.print("\n---------ИТОГ---------\n" +
                "Max отрицательное: " + polemas.mass[n1] + ", место - " + (n1+1)+"\n" +
                "Min положительное: " + polemas.mass[n2] + ", место - " + (n2+1)+"\n");
        polemas=change.elements(polemas,n1,n2);
        System.out.println("---------Новый массив---------");
        for (byte i = 0; i < k; i++) {
            System.out.print(polemas.mass[i]+" ");
        }
    }

}
