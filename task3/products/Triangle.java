// 三角形
package products;

public class Triangle extends PlaneProduct{
    //直角三角形
    double width;
    double height;
    public Triangle(String name_producer, int wid, int hei){
        planekind = 1;
        this.name_producer = name_producer;
        this.width = wid;
        this.height = hei;
    }
    public void area_cal(){
        this.area = width * height / 2;
    }
}
