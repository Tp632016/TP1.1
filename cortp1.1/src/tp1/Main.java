/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Length;

/**
 *
 * @author Quentin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            // Exo 1.1.1
            NombreA2Chiffres nb1;
  
            nb1 = new NombreA2Chiffres(1, 4);
            System.out.println("1.1.1 - Cas OK");
            System.out.println(nb1.toString()+"\n");
            
       
            
            NombreA2Chiffres nb3 = new NombreA2Chiffres(-1, -3);
            System.out.println("1.1.1 - Cas KO 2 ");
            System.out.println(nb3.toString()+"\n");
            
            // Exo 1.1.2
            // Addition OK
            NombreA2Chiffres nb4 = arith(2,3,false);
            System.out.println("1.1.2 - Addition OK ");
            System.out.println(nb4.toString()+"\n");
            
            // Addition2 OK
            NombreA2Chiffres nb5 = arith(6,8,false);
            System.out.println("1.1.2 - Addition2 OK ");
            System.out.println(nb5.toString()+"\n");
            
            // Multi OK
            NombreA2Chiffres nb6 = arith(2,3,true);
            System.out.println("1.1.2 - Multi OK ");
            System.out.println(nb6.toString()+"\n");
            
            // Multi2 OK
            NombreA2Chiffres nb7 = arith(5,3,true);
            System.out.println("1.1.2 - Multi2 OK ");
            System.out.println(nb7.toString()+"\n");
            
            
            
            System.out.println("1.1.3 - Somme OK ");
            int [] b=new int[3]; //86
            int [] c= new int[2]; //972
            
            b[0]=9;
            b[1]=9;
            b[2]=9;
            
            c[0]=9;
            c[1]=9;
            
            System.out.print(" ");
            
            for(int i=b.length-1;i>=0;i--)
            {
                System.out.print(b[i]);
            }
            
            System.out.print(" + ");
            
            for(int i=c.length-1;i>=0;i--)
            {
                System.out.print(c[i]);
            }
            
            int [] nb8 = sommeNombre(c,b);
            
            System.out.print(" = ");
            for(int i=nb8.length-1;i>=0;i--)
            {
                System.out.print(nb8[i]);
            }
            System.out.println();
            
            
            int [] bmul= {2,2,1};
            int [] cmul= {8,4};
            
            int [] result = mulNombre(bmul,cmul);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    
    public static int [] sommeNombre(int [] nb1, int [] nb2) throws Exception
    {
        int [] result = null;
        NombreA2Chiffres tmp,tmp2;
        int retenu = 0;
        int [] gdNb, ptNb;
        
        if(nb1.length >= nb2.length) { gdNb = nb1; ptNb = nb2; }
        else { gdNb = nb2; ptNb = nb1; }
            
        result = new int [gdNb.length+1];

        for(int i=0;i<gdNb.length;i++)
        {
            if(i < ptNb.length)
            {
                tmp = arith(gdNb[i], retenu, false);
                tmp2 = arith(tmp.getC2(), ptNb[i], false);
                retenu = tmp2.getC1()+tmp.getC1();
                result[i] = tmp2.getC2();
            }
            else
            {
                tmp = arith(gdNb[i], retenu, false);
                retenu = tmp.getC1();
                result[i] = tmp.getC2();
            }

        }
        if(retenu > 0)
        {
            result[gdNb.length] += retenu;
        }
        
      
        if(result[gdNb.length] == 0)
        {
            int [] supZero = new int [gdNb.length];
            System.arraycopy(result, 0, supZero, 0, supZero.length);
            return supZero;
        }
        else
        {
            return result;
        }
      
    }
    
    
    public static int [] mulNombre(int [] nb1, int [] nb2) throws Exception
    {
        int tailleTab = nb1.length + nb2.length;
        int [] result = {};
        int [] gdNb, ptNb;
        NombreA2Chiffres tmp,tmp2;
        int retenu = 0;
                
        if(nb1.length >= nb2.length) { gdNb = nb1; ptNb = nb2; }
        else { gdNb = nb2; ptNb = nb1; }
        
        int [][] resultTmp = new int[ptNb.length][tailleTab];
        
        for(int j=0; j<ptNb.length; j++)
        {
            for(int i=0; i < gdNb.length; i++)
            {
                
                tmp = arith(ptNb[j],gdNb[i], true);
                tmp2 = arith(tmp.getC2(),retenu,false);
                retenu = tmp.getC1() + tmp2.getC1();
                resultTmp[j][i+j] = tmp2.getC2();
                
                
            }
        }
        
        
        // Calcul du résultat final
        for(int j=0; j<ptNb.length;j++ )
        {
            result = sommeNombre(result,resultTmp[j]);
        }
        
        
        if(result[tailleTab-1] == 0)
        {
            int [] supZero = new int [tailleTab-1];
            System.arraycopy(result, 0, supZero, 0, supZero.length);
            return supZero;
        }
        else
        {
            return result;
        }
    }
    
    public static NombreA2Chiffres arith(int x, int y, boolean b) throws Exception
    {
        if(NombreA2Chiffres.testChiffre(x) && NombreA2Chiffres.testChiffre(y))
        {
            int c1,c2,result;
            
            if(b) {
                // Multiplication
                result = x * y;
            }
            else
            {
                // Addition
                result = x + y;
            }
            
            c1 = result/10;
            c2 = result - (c1*10);
            
            return new NombreA2Chiffres(c1,c2);
        }
        else
        {
            throw new Exception("Arith: Bad param");
        }
    
    }
}
