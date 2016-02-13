/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;


/**
 *
 * @author Quentin CHAPELLE
 */
public final class NombreA2Chiffres {
    
    private int mC1 = -1;
    private int mC2 = -1;
    
    public static boolean testChiffre(int c)
    {
        return (c<=9 && c>=-9);
    }

    @Override
    public String toString() {
        return " C1: "+mC1+" C2: "+mC2+" Nombre: "+mC1+""+mC2;
    }
    
    
    public NombreA2Chiffres(int c1, int c2) throws Exception
    {
        if( testChiffre(c1) && testChiffre(c2))
        {
            mC1 = c1;
            mC2 = c2;
        }
        else
        {
            throw new Exception("Param Incorrect");
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
    

    /**
     * @return the c1
     */
    public int getC1() {
        return mC1;
    }

    /**
     * @param c1 the c1 to set
     */
    public void setC1(int c1) {
        this.mC1 = c1;
    }

    /**
     * @return the c2
     */
    public int getC2() {
        return mC2;
    }

    /**
     * @param c2 the c2 to set
     */
    public void setC2(int c2) {
        this.mC2 = c2;
    }
    
}
