
public class ScoreTester
{
    public static void main(String[] args) 
    {
        
        Background b1 = new Background("background.txt");
        //CSprite p1
        //b1.set_vector(new Vector(0,0));
        Canvas can =  new Canvas(b1);
        //Canvas can = new Canvas(40,20);
        Scoreboard s1 = new Scoreboard("Score:", 10,10,0);
        CSprite s2 = new CSprite(6, 4, 0, new Vector(1, 0), new char[][]{{'1','2','3'}, {'4','5','6'}},2); 
        s1.add(10);
        can.addSprite(s1);
        can.animate();
    }
}
