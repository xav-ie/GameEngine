public interface ISprite
{
    int get_x();
    int get_y();
    int get_z();
    char[][] get_map();
    Vector get_vector();
    void animate();
    void collision(int x, int y, SpriteArrayList s);
    boolean isClear(int x, int y, int z);
    void rotate();
}
