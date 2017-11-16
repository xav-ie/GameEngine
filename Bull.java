
public class Bull extends CSprite
{
    int m_damage = 10;
    String m_type = "classic";
    int m_health = 30;
    int m_counter = 0;
    public Bull(int x, int y, int z, Vector v, int speed)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
    }

    public Bull(int x, int y, int z, Vector v, int speed, int health)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_health = health;
    }

    public Bull(int x, int y, int z, Vector v, int speed, String type)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_type = type;
    }

    public Bull(int x, int y, int z, Vector v, int speed, String type, int health)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_type = type;
        m_health = health;
    }

    public Bull(int x, int y, int z, int damage, Vector v, int speed)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_damage = damage;
    }
    public Bull(int x, int y, int z, int damage, Vector v, int speed, int health)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_damage = damage;
        m_health = health;
    }

    public Bull(int x, int y, int z, Vector v, int speed, int damage, String type)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_damage = damage;
        m_type = type;
    }

    public Bull(int x, int y, int z, Vector v, int speed, int damage, String type, int health)
    {
        super(x,y,z,v,new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}}, speed);
        m_damage = damage;
        m_type = type;
        m_health = health;
    }

    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s!=this)
            {
                if (s instanceof Duck)  // collion with some other sprite
                {
                    //Canvas.removeSprite(this);
                    //System.out.println("Removing Ghost");
                    CAvatar a = Canvas.get_Avatar();
                    if (a != null)
                    {
                        if (a.get_x() > m_x && isClear(m_x-3,m_y,m_z))m_x-=3;
                        if (a.get_x() < m_x && isClear(m_x+3,m_y,m_z))m_x+=3;
                        if (a.get_y() > m_y && isClear(m_x,m_y-1,m_z))m_y--;
                        if (a.get_y() < m_y && isClear(m_x,m_y+1,m_z))m_y++;
                    }
                }
                if (s instanceof Bullet)  // collion with some other sprite
                {
                    this.hit(10);
                }
            }
    }

    public void animate()
    {
        CAvatar a = Canvas.get_Avatar();
        if (a != null)
        {
            if (a.get_x() < m_x && isClear(m_x-1,m_y,m_z))m_x--;
            if (a.get_x() > m_x && isClear(m_x+1,m_y,m_z))m_x++;
            if (a.get_y() < m_y && isClear(m_x,m_y-1,m_z))m_y--;
            if (a.get_y() > m_y && isClear(m_x,m_y+1,m_z))m_y++;
        }
        if (m_counter != 0) 
        {
            m_counter--;
            //m_map = new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','@',' ',' ','@','-','\''},{' ','(','o','_','_','o',')',' '}};
            this.rotate();
        }
        if (m_counter == 0) m_map = new char[][]{{' ', '_', '(', '_', '_', ')', '_'}, {'\'', '-','0',' ',' ','0','-','\''},{' ','(','o','_','_','o',')',' '}};
    }

    public void hit(int damage)
    {
        m_health -= damage;
        m_counter += 5;
        if (m_health <=0) Canvas.removeSprite(this);
    }

    public int getDamage(){return m_damage;}
}
