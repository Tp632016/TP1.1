/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;


/**
 *
 * @author Quentin CHAPELLE
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static int [] sommeNombre(int [] nb1, int [] nb2) throws Exception
    {
        int [] result;
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
                tmp = NombreA2Chiffres.arith(gdNb[i], retenu, false);
                tmp2 = NombreA2Chiffres.arith(tmp.getC2(), ptNb[i], false);
                retenu = tmp2.getC1()+tmp.getC1();
                result[i] = tmp2.getC2();
            }
            else
            {
                tmp = NombreA2Chiffres.arith(gdNb[i], retenu, false);
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
        int [] gdNb, ptNb, result = {};
        NombreA2Chiffres tmp,tmp2;
        int retenu = 0;
        
             
        if(nb1.length >= nb2.length) { 
            gdNb = nb1; ptNb = nb2; 
        }
        else { 
            gdNb = nb2; ptNb = nb1; 
        }
        
        int [][] resultTmp = new int[ptNb.length][tailleTab];
        
        for(int j=0; j<ptNb.length; j++){
            for(int i=0; i < gdNb.length; i++){
                
                tmp = NombreA2Chiffres.arith(ptNb[j],gdNb[i], true);
                tmp2 = NombreA2Chiffres.arith(tmp.getC2(),retenu,false);
                retenu = tmp.getC1() + tmp2.getC1();
                resultTmp[j][i+j] = tmp2.getC2();
                
                
            }
        }
        
        
        // Calcul du résultat final
        for(int j=0; j<ptNb.length;j++ ) {
            result = sommeNombre(result,resultTmp[j]);
        }
        
        
        if(result[tailleTab-1] == 0) {
            int [] supZero = new int [tailleTab-1];
            System.arraycopy(result, 0, supZero, 0, supZero.length);
            return supZero;
        }
        else
        {
            return result;
        }
    }
    
}
