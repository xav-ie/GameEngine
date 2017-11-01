public class VideoGame
{
    public static void main(String[] args)
    {
        CSprite s1 = new CSprite(6, 4, 0, new Vector(1, 0), new char[][]{{'1','2','3'}, {'4','5','6'}},2); 
        Ghost g1 = new Ghost(20, 10, 0, new Vector(1, 0), new char[][]{{'*','*'}, {'*','*','*'}, {'*','*','*'}},2); 
//        CAvatar a1 = new CAvatar(8, 4, 0, new Vector(0, 0), new char[][]{{'a',' ','c'}, {'d','e','f'}});
        CAvatar a1 = new CAvatar("avatar.txt", 8,20,0);
        CSprite b1 = new CSprite("background.txt");
        //b1.set_vector(new Vector(0,0));
        Canvas can =  new Canvas(b1);
//        Canvas can = new Canvas(40,20);
        can.addSprite(s1);
        can.addSprite(g1);
        can.addSprite(a1);
        can.animate();

    }
}
