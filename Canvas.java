import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Canvas extends KeyAdapter
{
    int m_height;
    int m_width;
    static ArrayList<CSprite> m_sprites;
    static SpriteArrayList[][] m_spriteMap;
    GameConsole m_console;

    public Canvas(CSprite background)
    {
        m_height = background.get_map().length + 1;
        m_width = background.get_map()[0].length + 1;

        m_sprites = new ArrayList<CSprite>();
        m_console = new GameConsole(m_width,m_height, this);

        m_console.setVisible(true);
        addSprite(new CSprite(1,m_height -1 ,0,background.get_vector(),background.get_map()));
    }

    public Canvas(int w, int h)
    {
        m_height = h;
        m_width = w;
        m_sprites = new ArrayList<CSprite>();
        m_console = new GameConsole(w, h, this);

        m_console.setVisible(true);

    }

 
    public static CAvatar get_Avatar()
    {
        for(CSprite c : m_sprites)
        {
            if (c instanceof CAvatar)
                return (CAvatar) c;
        }
        return null;
    }

    public static SpriteArrayList get_SpritesAt(int x, int y)
    {
        if (m_spriteMap != null && x > 0 && x < m_spriteMap.length && y > 0 && y < m_spriteMap[x].length) 
            return m_spriteMap[x][y];
        return null;
    }


    public static void addSprite(CSprite c)
    {
        m_sprites.add(c);   
    }

    public static void removeSprite(CSprite c)
    {
        m_sprites.remove(c);   
    }

    public void draw()
    {
        this.sortZ(m_sprites);
        char[][] char_map = new char[m_height][m_width];
        m_spriteMap = new SpriteArrayList[m_height][m_width];

        // initialize with spaces
        for(int i = 0; i < char_map.length ; i++)
            for(int j = 0; j < char_map[i].length ; j++)
            {
                char_map[i][j] = ' ';
                m_spriteMap[i][j] = new SpriteArrayList();
            }

        for(int i = 0; i< m_sprites.size(); i++)//For every Sprite
        {
            CSprite s = m_sprites.get(i);
            // for every char in sprite, place on map
            for(int sy = 0; sy < s.get_map().length;sy++)//for every row in sprite
            {
                for(int sx = 0; sx < s.get_map()[sy].length;sx++)// place every character if it's on the map
                {
                    if (s.get_y() - sy > 0 && s.get_y() - sy < m_height &&
                    s.get_x() + sx > 0 && s.get_x() + sx < m_width && s.get_map()[sy][sx]!=' ')
                    {
                        char_map[s.get_y()-sy][s.get_x()+sx] = s.get_map()[sy][sx];
                        m_spriteMap[s.get_y()-sy][s.get_x()+sx].add(s);
                    }
                }
            }
        }
        // Notify every sprite about every collision
        for(int i = m_height -1; i >=0; i--)
            for(int j = 0; j < m_spriteMap[i].length ; j++)
                for(CSprite c : m_spriteMap[i][j])
                    c.collision(i,j,m_spriteMap[i][j]);

        // Go through the map and turn into a string (with newlines)
        String map = "";
        for(int i = m_height - 1; i >= 0; i--)// start at top left
        {
            for(int j = 0; j < char_map[i].length ; j++)
                map += Character.toString(char_map[i][j]);
            map+= "\n";
        }
        m_console.setText(map);
    }

    public void animate()
    {
        while(true)
        {
            try
            {
                Thread.sleep(200);
                for(int i = 0; i< m_sprites.size(); i++)//For every Sprite
                {
                    CSprite s = m_sprites.get(i);
                    s.animate();
                }
                draw();
            } 
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    private void sortZ(ArrayList<CSprite> alist)
    {
        Collections.sort(alist);
        m_sprites = alist;
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        for(int i = 0; i< m_sprites.size(); i++)//For every Sprite
        {
            if (m_sprites.get(i) instanceof CAvatar)
                ((CAvatar) m_sprites.get(i)).keyPressed(event);
        }
        draw();
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        for(int i = 0; i< m_sprites.size(); i++)//For every Sprite
        {
            if (m_sprites.get(i) instanceof CAvatar)
                ((CAvatar) m_sprites.get(i)).keyReleased(event);
        }
        draw();
    }
}
