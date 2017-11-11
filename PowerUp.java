
public class PowerUp extends CSprite
{
    boolean m_XMoving = true;
    boolean m_YMoving = true;
    private String m_type = "None";
    public PowerUp(int x, int y, int z, Vector v, char[][] map, int speed)
    {
        super(x,y,z,v,map, speed);
    }

    public PowerUp(int x, int y, int z, Vector v, String type, int speed)
    {
        this(x,y,z,v,new char[][]{{'*','*','*'},{'*','*','*'}}, speed);
        m_type = type;
        if (type=="tiny") m_map = new char[][]{{'>','|','<'},{'>','|','<'}};
        if (type=="fast") m_map = new char[][]{{'>','>','>'},{'>','>','>'}};
        if (type=="slow") m_map = new char[][]{{'<','<','<'},{'<','<','<'}};
        if (type=="invincible") m_map = new char[][]{{' ','_',' '},{'|','_','|'}};
    }

    public String getType() {return m_type;}

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
                System.out.println(this.getCoords());
                m_XMoving = false;
                m_YMoving = false;
                if(m_XMoving&&m_YMoving) System.out.println("yeet");
            }
        }
    }

    public void animate()
    {
        CAvatar a = Canvas.get_Avatar();
        if (m_type!="slow")
        {
            if (a.get_x()>=94)m_x-=2; //must span width of duck
            if (a.get_x()<=2)m_x++;
            if (a.get_y()>=37) m_y--;
            if (a.get_y()<=4) m_y++;
            if (m_y<=4||m_y>=37) {
                m_YMoving=false;
                if (m_y<=4) m_y = 4;
                if (m_y>=37) m_y = 37;
            } else {m_YMoving=true;}
            if (m_x<=3||m_x>=99) {
                m_XMoving=false;
                if (m_x<=3) m_x = 3;
                if (m_x>=99) m_x = 99;
            } else {m_XMoving=true;}
            if (a != null)
            {
                if (m_XMoving)
                {
                    if (a.get_x() < m_x && isClear(m_x+1,m_y,m_z))m_x++;
                    if (a.get_x() > m_x && isClear(m_x-1,m_y,m_z))m_x--;
                }
                if (m_YMoving)
                {
                    if (a.get_y() < m_y && isClear(m_x,m_y+1,m_z))m_y++;
                    if (a.get_y() > m_y && isClear(m_x,m_y-1,m_z))m_y--;
                }
            }
        } else {
            if (a != null)
            {
                if (a.get_x() < m_x && isClear(m_x-1,m_y,m_z))m_x--;
                if (a.get_x() > m_x && isClear(m_x+1,m_y,m_z))m_x++;
                if (a.get_y() < m_y && isClear(m_x,m_y-1,m_z))m_y--;
                if (a.get_y() > m_y && isClear(m_x,m_y+1,m_z))m_y++;
            }
        }
    }

}
