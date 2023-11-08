// 长方体
package products;

public class Cuboids extends ThreeDProduct{
    double length;
    double width;
    double height;
    public Cuboids(String name_producer, double len, double wid, double hei){
        planekind = 0;
        this.name_producer = name_producer;
        this.length = len;
        this.width = wid;
        this.height = hei;
    }
    public void volume_cal(){
        this.volume = length * width * height;
    }

}
