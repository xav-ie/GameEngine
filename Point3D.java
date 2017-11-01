
public class Point3D 
{
    int m_x,m_y,m_z;
    public Point3D()
    {
        this(0,0,0);
    }
    public Point3D(int x, int y)
    {
        this(x,y,0);
    }
    public Point3D(int x, int y, int z)
    {
        m_x = x;
        m_y = y;
        m_z = z;
    }
    public Point3D X_reflection()
    {
        return new Point3D(m_x,-m_y,m_z);
    }
    public Point3D Y_reflection()
    {
        return new Point3D(-m_x,m_y,m_z);
    }
    public String toString()
    {
        return "(" + m_x + "," + m_y + "," + m_z + ")";
    }
    public int compareTo(Point3D p)
    {
        if (p.m_z < m_z) return -1;
        if (p.m_z == m_z) return 0;
        if (p.m_z > m_z) return 1;
        
        return 0;
    }
    
    public static void main(String args[])
    {
        // Write a Point3D class to allow the following code to run and produce the output shown.
        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D(4,-2);
        Point3D p3 = new Point3D(3,5,-1);
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p3.X_reflection());
        System.out.println(p3.Y_reflection());

         /* Your output should be:
         (0,0,0)
         4,-2,0)
         (3,5,-1)
         (3,-5,-1)
         (-3,5,-1)
         */

    }
    
}
