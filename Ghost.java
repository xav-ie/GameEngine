
public class Ghost extends CSprite
{
    public Ghost(int x, int y, int z, Vector v, char[][] map, int speed)
    {
        super(x,y,z,v,map, speed);
    }

    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s instanceof CSprite)  // collion with some other sprite
            {
                Canvas.removeSprite(this);
                System.out.println("Removing Ghost");
            }
    }

    public void animate()
    {
        CAvatar a = Canvas.get_Avatar();
        if (a != null)
        {
            if (a.get_x() < m_x && isClear(m_x-1,m_y,m_z))
                m_x--;
            if (a.get_x() > m_x && isClear(m_x+1,m_y,m_z))
                m_x++;
            if (a.get_y() < m_y && isClear(m_x,m_y-1,m_z))
                m_y--;
            if (a.get_y() > m_y && isClear(m_x,m_y+1,m_z))
                m_y++;
        }
    }
}
