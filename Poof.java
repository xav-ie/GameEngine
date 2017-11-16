
public class Poof extends CSprite
{
    private int m_tick, m_speed;
    public Poof(int x, int y, int z)
    {
        super(x,y,z, new Vector(0,0), new char[][]{{' ',' ',' ',' ',' '},{' ',' ','*',' ',' '},{' ',' ',' ',' ',' '}});
        m_speed = 6;
    }
    
    public void animate()
    {
        if (++m_tick % (m_speed) == 0) // if speed is 3 it only does this every third time etc.
        {
            Canvas.removeSprite(this);
        }
        /*if (m_tick == 2) m_map = new char[][]{{' ',' ','*',' ',' '},{' ',' ','*',' ',' '},{' ',' ','*',' ',' '}};
        if (m_tick == 3) m_map = new char[][]{{' ',' ','*',' ',' '},{' ','*',' ','*',' '},{' ',' ','*',' ',' '}};
        if (m_tick == 5) m_map = new char[][]{{' ',' ','*',' ',' '},{'*',' ','*',' ','*'},{' ',' ','*',' ',' '}};
        if (m_tick == 7) m_map = new char[][]{{' ',' ',' ',' ',' '},{' ','*',' ','*',' '},{' ',' ',' ',' ',' '}};
//        if (m_tick == 8) m_map = new char[][]{{' ',' ','*',' ',' '},{' ',' ','*',' ',' '},{' ',' ','*',' ',' '}};
        if (m_tick == 8) m_map = new char[][]{{' ',' ',' ',' ',' '},{' ',' ','*',' ',' '},{' ',' ',' ',' ',' '}};*/
        
        if (m_tick == 3) m_map = new char[][]{{' ',' ','*',' ',' '},{'*',' ','*',' ','*'},{' ',' ','*',' ',' '}};
        if (m_tick == 4) m_map = new char[][]{{' ',' ','*',' ',' '},{'*',' ',' ',' ','*'},{' ',' ','*',' ',' '}};
        if (m_tick == 5) m_map = new char[][]{{' ',' ',' ',' ',' '},{' ',' ','*',' ',' '},{' ',' ',' ',' ',' '}};
        
        //if (m_tick == 3) m_map = new char[][]{{' ',' ','*',' ',' '},{'*',' ','*',' ','*'},{' ',' ','*',' ',' '}};
        //if (m_tick == 7) m_map = new char[][]{{' ',' ',' ',' ',' '},{' ',' ','*',' ',' '},{' ',' ',' ',' ',' '}};
    }
}