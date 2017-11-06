import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CAvatar extends CSprite
{
    String m_fileName;
    int m_counter = 0;
    public CAvatar(String fileName, int x, int y, int z)
    {
        super(fileName,x,y,z);
        m_fileName = fileName.substring(0,fileName.length()-4); //get the actual file name, not the extension
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
        //m_counter++;
        /*if (m_counter%10==0) 
        {
            m_counter=0;
            CSprite s1 = new CSprite(6, 4, 0, new Vector(1, 0), new char[][]{{'1','2','3'}, {'4','5','6'}},2); 
            Canvas.addSprite(s1);
        }*/
    }

    public void keyPressed(KeyEvent event)
    {
        int new_x = m_x;
        int new_y = m_y;

        int keyCode = event.getKeyCode();
        if (keyCode == event.VK_SPACE)
        {

            //int y = m_vector.get_y();
            int x = (m_vector.get_x()<0) ? -2 : 7;
            if(m_vector.get_y()!=0) x = -2; //if it is going to shoot up/down, make the ullet spawn by the beak

            CSprite s = new CSprite("Sprite1.txt",     // filename
                    m_x + x + get_map().length/2,      // x coord of center of our shape
                    m_y + 4 + - get_map()[0].length/2, // y coord of center of our shape
                    m_z); 
            s.set_vector(m_vector);                    // send in the same direction we are going
            s.set_speed(1);

            Canvas.addSprite(s);

        }
        if (keyCode == event.VK_LEFT)
        {
            if(m_fileName!=null) setMap(m_fileName+"Left.txt");
            m_vector = new Vector(-1,0);
            new_x--;
        }
        if (keyCode == event.VK_RIGHT)
        {
            if(m_fileName!=null) setMap(m_fileName+"Right.txt");
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

    private void setMap(String fileName)
    {
        String content = null;
        String rows[] = null;
        char [][] map;
        int height = 0;
        int width = 0;

        try
        {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
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

            m_map = map;
        } catch (IOException e)
        {
            // Do nothing 
        } 

    }

    public void keyReleased(KeyEvent event)
    {
    }

}
