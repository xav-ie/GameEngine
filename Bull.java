 
public class Bull extends CSprite
{
    int m_damage = 10;
    public Bull(int x, int y, int z, Vector v, int speed)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
    }
    public Bull(int x, int y, int z, Vector v, int speed, int damage)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_damage = damage;
    }

    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s!=this)
              if (s instanceof Duck)  // collion with some other sprite
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
            if (a.get_x() < m_x && isClear(m_x+1,m_y,m_z))m_x--;
            if (a.get_x() > m_x && isClear(m_x-1,m_y,m_z))m_x++;
            if (a.get_y() < m_y && isClear(m_x,m_y+1,m_z))m_y--;
            if (a.get_y() > m_y && isClear(m_x,m_y-1,m_z))m_y++;
        }
    }
    public int getDamage(){return m_damage;}
}
