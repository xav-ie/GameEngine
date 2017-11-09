
public class PowerUp extends CSprite
{
    boolean m_XMoving = true;
    boolean m_YMoving = true;
    public PowerUp(int x, int y, int z, Vector v, char[][] map, int speed)
    {
        super(x,y,z,v,map, speed);
    }

    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList){
            if (s instanceof CAvatar)  // collion with some other sprite
            {
                Canvas.removeSprite(this);
                System.out.println("Removing PowerUp");
            }
            if (s instanceof Background)
            {
                m_XMoving = false;
                m_YMoving = false;
                if(m_XMoving&&m_YMoving) System.out.println("yeet");
            }
        }
    }

    public void animate()
    {
        CAvatar a = Canvas.get_Avatar();
        if (a != null && m_XMoving && m_YMoving)
        {
            if (a.get_x() < m_x && isClear(m_x-1,m_y,m_z))
                m_x++;
            if (a.get_x() > m_x && isClear(m_x+1,m_y,m_z))
                m_x--;
            if (a.get_y() < m_y && isClear(m_x,m_y+1,m_z))
                m_y++;
            if (a.get_y() > m_y && isClear(m_x,m_y+1,m_z))
                m_y--;
                
            /*if (a.get_x() < m_x && !isClear(m_x-1,m_y,m_z))
                m_x+=1;
            if (a.get_x() > m_x && isClear(m_x+1,m_y,m_z))
                m_x--;
            if (a.get_y() < m_y && isClear(m_x,m_y+1,m_z))
                m_y++;
            if (a.get_y() > m_y && isClear(m_x,m_y+1,m_z))
                m_y--;*/
        }
    }

    
    
}
