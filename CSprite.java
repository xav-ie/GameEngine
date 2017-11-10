import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSprite implements ISprite, Comparable
{
    Vector m_vector;
    private int m_tick;
    protected int m_x, m_y, m_z;
    private int m_speed;
    protected char[][] m_map;

    public CSprite(String fileName){this(fileName, 0,0,0);}

    public CSprite(String fileName, int x, int y, int z)
    {
        String content = null;
        String rows[] = null;
        char [][] map;
        int height = 0;
        int width = 0;

        try
        {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e)
        {
            content = e.toString();
        }
        rows = content.split("\r\n");
        height = rows.length;
        for (String r : rows)
            if (r.length() > width) width = r.length();// set width to widest row
        
        map = new char[height][width];
        for (int i = 0; i < rows.length; i++)
            if (rows[i].length() > width) width = rows[i].length();
        for (int i = 0; i < rows.length;i++)
            for (int j = 0; j < rows[i].length() ;j++)
                map[i][j] = rows[i].charAt(j);
        m_x = x;
        m_y = y;
        m_z = z;
        m_speed = 1;
        m_map = map;
        m_vector = new Vector();
    }    

    public CSprite(){this(0,0,0,new Vector());}

    public CSprite(int x, int y){this(x,y,0,new Vector());}

    public CSprite(int x, int y, int z){this(x,y,z,new Vector());}

    public CSprite(int x, int y, int z, Vector v){this(x, y, z, v, new char[][]{{'*'}});}

    public CSprite(int x, int y, int z, Vector v, char[][] map){this(x, y, z, v, map, 1);}

    public CSprite(int x, int y, int z, Vector v, char[][] map, int speed)
    {
        m_x = x;
        m_y = y;
        m_z = z;
        if (v == null) v = new Vector(0,0);
        m_vector = v;
        m_map = map;
        switch (speed)
        {
            case 1:
            case 2:
            case 5:
            case 10:
            m_speed = speed;
            break;
            default:
            m_speed = 1;
        }
        m_speed = speed;
    }
    public int get_speed() { return m_speed;};
    public void set_speed(int speed) { m_speed = speed;};
    public int get_x(){ return m_x; }
    public int get_y(){ return m_y; }
    public int get_z(){return m_z;}
    public String getCoords(){return "("+m_x+", "+m_y+", "+m_z+")";}
    public int[] coords(){return new int[]{m_z, m_y, m_z};}
    public char[][] get_map(){return m_map;}
    public Vector get_vector() { return m_vector;}
    public void set_vector(Vector v) { m_vector = v;};

    public String toString()
    {
        String map = "";
        for(int i = 0; i < m_map.length ; i ++)
        {
            for(int j = 0; j < m_map[i].length ; j ++)
                map += Character.toString(m_map[i][j]);
            map+= "\n";
        }        
        return (map);
    }

    public boolean equals(Object other)
    {
        CSprite temp = (CSprite) other;
        if(other instanceof CSprite)
            if(m_x==temp.m_x && m_y==temp.m_y && m_z==temp.m_z && m_vector.equals(temp.m_vector))
                return true;
        return false;
    }

    public void animate()
    {
        if (++m_tick % (m_speed) == 0) // if speed is 3 it only does this every third time etc.
        {
            m_tick = 0;
            m_y += m_vector.get_y();
            m_x += m_vector.get_x();
        }
    }
    
    public String getType() {return "None";}
    public void rotate()
    {
        int height = m_map.length;
        int width = m_map[0].length;
        char[][] rMap = new char[width][height];
        for(int i = 0, k = height - 1;i < height;i++, k--)
        {
            for(int j = 0;j < width;j++)
            {
                rMap[j][k] = m_map[i][j];
            }
        }
        m_map = rMap;
    }

    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s != this)  // collision with some other sprite
            {
                //if (s instanceof Bull) Canvas.removeSprite(s);
                if(s instanceof Bullet) Canvas.removeSprite(s);
                //if (s instanceof PowerUp) Canvas.removeSprite(s);
                //Canvas.removeSprite(this); 
                //rotate();
                //System.out.println("(" + x + "," + y + ")");
                //System.out.println(s);
            }
    }

    public boolean isClear(int x, int y, int z)
    {
        // check if our sprite is clear on this canvas
        for(int i = 0; i < m_map.length;i++)
            for(int j=0; j < m_map[0].length;j++)
            {
                SpriteArrayList sl = Canvas.get_SpritesAt(y - i,x + j);
                if (sl != null)
                {
                    for(CSprite s : sl)
                        if (s != this && s.get_z() == m_z)
                        {
                            //System.out.println(this+"peep");
                            //Canvas.removeSprite(this); 
                            return false;
                        }
                }
            }
        return true;
    }
    
    public int compareTo(Object o1)
    {
        if (o1 instanceof CSprite)
        {
            if(this.get_z() > ((CSprite)o1).get_z())return 1;
            if(this.get_z() == ((CSprite)o1).get_z())return 0;
            if(this.get_z() < ((CSprite)o1).get_z())return -1;
        }
        return 0;
    }

}

class SpriteArrayList extends ArrayList<CSprite> {}