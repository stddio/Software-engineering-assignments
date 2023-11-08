// 圆柱体
package products;

public class Cylinder extends ThreeDProduct{
    double radius;
    double height;
    public Cylinder(String name_producer, double radius, double hei){
        planekind = 1;
        this.name_producer = name_producer;
        this.radius = radius;
        this.height = hei;
    }
    public void volume_cal(){
        this.volume = Math.PI * radius * radius * height;
    }

}
