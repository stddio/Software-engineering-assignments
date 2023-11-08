// 梯形
package products;
public class Trapezoid extends PlaneProduct{
    double width1;
    double width2;
    double height;
    public Trapezoid(String name_producer, double wid1, double wid2, double hei){
        planekind = 2;
        this.name_producer = name_producer;
        this.width1 = wid1;
        this.width2 = wid2;
        this.height = hei;
    }
    public void area_cal(){
        this.area = (width1 + width2) * height / 2;
    }
}
