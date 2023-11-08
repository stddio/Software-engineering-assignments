// 球体
package products;

public class Sphere extends ThreeDProduct{
    double radius;
    public Sphere(String name_producer, double radius){
        planekind = 2;
        this.name_producer = name_producer;
        this.radius = radius;
    }
    public void volume_cal(){
        this.volume = 4 * Math.PI * radius * radius * radius / 3;
    }

}
