public class VideoGame
{
    public static void main(String[] args)
    {
        //CSprite s1 = new CSprite(6, 4, 0, new Vector(1, 0), new char[][]{{'1','2','3'}, {'4','5','6'}},2); 
        PowerUp p1 = new PowerUp(12, 12, 1, new Vector(1, 1), "tiny",10);
        Bull bull1 = new Bull(20, 10, 1, new Vector(1, 0),10);
        Scoreboard s1 = new Scoreboard("Score:", 1,38,0);
//        CAvatar a1 = new CAvatar(8, 4, 0, new Vector(0, 0), new char[][]{{'a',' ','c'}, {'d','e','f'}});
        Duck d1 = new Duck("avatartiny.txt", 18,20,0);
        Background b1 = new Background("background.txt");
        //CSprite p1
        //b1.set_vector(new Vector(0,0));
        Canvas can =  new Canvas(b1);
//        Canvas can = new Canvas(40,20);
        //can.addSprite(s1);
        can.addSprite(bull1);
        can.addSprite(d1);
        can.addSprite(p1);        
        can.addSprite(s1);
        can.animate();

    }
}
