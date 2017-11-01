import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class CAvatar extends CSprite
{
    public CAvatar(String fileName, int x, int y, int z)
    {
        super(fileName,x,y,z);
        m_vector = new Vector(0,1);
    }
   
    public CAvatar(int x, int y, int z, Vector v, char[][] map)
    {
        super(x,y,z,v,map);
        m_vector = new Vector(0,1);
    }
    public void animate()
    {
        // Leave this empty so avatar won't move automatically like Sprites
    }

    public void keyPressed(KeyEvent event)
    {
        int new_x = m_x;
        int new_y = m_y;
        
        int keyCode = event.getKeyCode();
        if (keyCode == event.VK_SPACE)
        {
            CSprite s = new CSprite("Sprite1.txt",              // filename
                                    m_x + get_map().length/2,   // x coord of center of our shape
                                    m_y - get_map()[0].length/2,// y coord of center of our shape
                                    m_z); 
            s.set_vector(m_vector); // send in the same direction we are going
            s.set_speed(1);
            
            Canvas.addSprite(s);

        }
        if (keyCode == event.VK_LEFT)
        {
            m_vector = new Vector(-1,0);
            new_x--;
        }
        if (keyCode == event.VK_RIGHT)
        {
            m_vector = new Vector(1,0);
            new_x++;
        }
        if (keyCode == event.VK_UP)
        {
            m_vector = new Vector(0,1);
            new_y++;
        }
        if (keyCode == event.VK_DOWN)
        {
            m_vector = new Vector(0,-1);
            new_y--;
        }
        if (!isClear(new_x,new_y,m_z))
            System.out.println("(" + new_x + "," + new_y + ") - isn't clear.");
        else
        {
            m_x = new_x;
            m_y = new_y;
        }
    }

    public void keyReleased(KeyEvent event)
    {
    }

}
