import java.util.*;
public class Vector implements IVector
{
    int m_x;
    int m_y;
    public Vector()
    {
    }
    public Vector(int x, int y)
    {
        if (x>0) 
            m_x = 1;
        if (x<0) 
            m_x = -1;
        if (y>0) 
            m_y = 1;
        if (y<0) 
            m_y = -1;
    }
    public int get_x(){return m_x;}
    public int get_y(){return m_y;}
    public String toString()
    {
        return "(" + m_x + "," + m_y + ")";
    }
    
    /*public static void main(String args[])
    {
        Vector v1 = new Vector(1,1);
        System.out.println(v1);
        if (v1.toString().equals("(1,1)"))
            System.out.println("(1,1) worked!");
        
        Vector v2 = new Vector(-5,1);
        System.out.println(v2);
        if (v2.toString().equals("(-1,1)"))
            System.out.println("(-5,1) worked!");
        
        Vector v3 = new Vector(0,0);
        System.out.println(v3);
        if (v3.toString().equals("(0,0)"))
            System.out.println("(0,0) worked!");
    
    }*/
}
