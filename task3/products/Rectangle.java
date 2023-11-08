// 矩形
package products;

public class Rectangle extends PlaneProduct{
    double length;
    double width;
    public Rectangle(String name_producer, int len, int wid){
        planekind = 0;
        this.name_producer = name_producer;
        this.length = len;
        this.width = wid;
    }
    public void area_cal(){
        this.area = length * width;
    }

}


