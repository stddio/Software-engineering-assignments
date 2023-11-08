package products;
import java.util.Random;     //随机数
// import products.Product;

public class PlaneProduct extends Product {
    public int planekind;
    public double area;
    public String output = "";
   
    public void area_cal(){};

    public void display(int i){
        if(i == 0)   output += "\n消费: ";
        if(i == 1)   output += "生产: ";
        
        output += "产品生产者为" + this.name_producer + "  ";
        if(this.planekind == 0)  output += "产品为矩形  产品面积为  " + this.area;
        else if (this.planekind == 1)   output += "产品为三角形  产品面积为  " + this.area;
        else if (this.planekind == 2)   output += "产品为梯形  产品面积为  " + this.area;
        else{
            try{
                throw new Exception("该产品类型不正确");
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        // System.out.println(i+ " " + output.length());
        if(i == 0)  System.out.println(output);  // ???

    }
}