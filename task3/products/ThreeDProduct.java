//三维产品
package products;

public class ThreeDProduct extends Product {
    public int planekind;
    public double volume;
    String output = "";
    public void volume_cal(){};
    
    public void display(int i){
        if(i == 1)   output += "生产： ";
        if(i == 0)    output += "\n消费： ";
        output += "产品生产者为" + this.name_producer + "  ";
        if(this.planekind == 0)  output += "产品为长方体  产品体积为:  " + this.volume;
        else if (this.planekind == 1)   output += "产品为圆柱体  产品体积为:  " + this.volume;
        else if (this.planekind == 2)   output += "产品为球体  产品体积为:  " + this.volume;
        else{
            try{
                throw new Exception("该产品类型不正确");
            } catch(Exception e){
                System.out.println("error in 3d!!!");
                System.err.println(e.getMessage());
            }
        }
        if(i == 0)  System.out.println(output);
    }

    // public void display(){
    //     System.out.print("产品生产者：" + this.name_producer + "  ");
    //     if(this.planekind == 0)  System.out.println("产品为长方体  产品体积为:  " + this.volume);
    //     else if (this.planekind == 1)   System.out.println("产品为圆柱体  产品体积为:  " + this.volume);
    //     else if (this.planekind == 2)   System.out.println("产品为球体  产品体积为:  " + this.volume);
    //     else{
    //         try{
    //             throw new Exception("该产品类型不正确");
    //         } catch(Exception e){
    //             System.err.println(e.getMessage());
    //         }
    //     }
    //     // System.out.println("产品体积为：" + this.volume);
    // }
}
