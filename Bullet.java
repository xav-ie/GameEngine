
public class Bullet extends CSprite
{
    public Bullet(String fileName, int x, int y, int z)
    {
        super(fileName, x, y, z);
    }
    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s != this)  // collision with some other sprite
            {
                if(s instanceof CAvatar) Canvas.removeSprite(s);
                //if (s instanceof PowerUp) Canvas.removeSprite(s);
                //Canvas.removeSprite(this); 
                //rotate();
                //System.out.println("(" + x + "," + y + ")");
                //System.out.println(s);
            }
    }
}
