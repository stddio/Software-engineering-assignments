import products.PlaneProduct;//二维产品
import products.ThreeDProduct;//三维产品
import products.Rectangle;   //长方形
import products.Triangle;    //三角形
import products.Trapezoid;   //梯形
import products.Cuboids;     //长方体
import products.Cylinder;    //圆柱体
import products.Sphere;      //球体
import java.util.Random;     //随机数
import java.util.LinkedList;
import java.util.Queue;      //队列

public class ProducerConsumerTest {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer p2 = new Producer(c, 0); //二维生产者
        Producer p3 = new Producer(c, 1); //三维生产者
        Consumer c2 = new Consumer(c, 0); //二维消费者
        Consumer c3 = new Consumer(c, 1); //三维消费者
        p2.start();
        p3.start();
        c2.start();
        c3.start();
    }
}

class CubbyHole {
    public static int max_2d = 100;
    public static int max_3d = 100;
    private double contents_2d = 0;
    private double contents_3d = 0;
    private Queue<PlaneProduct> queue_2d;
    private Queue<ThreeDProduct> queue_3d;

    CubbyHole(){
        this.queue_2d = new LinkedList<>();
        this.queue_3d = new LinkedList<>();
    }

    //一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞。
    public synchronized PlaneProduct get_2d() {  //num为0:2d, 1:3d, tmp为面积/体积
        PlaneProduct product_2d;
        while(this.contents_2d == 0){ //二维产品仓库为空
            try{
                throw new Exception("error: 二维产品仓库为空");
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            try {
                wait();
            } catch(InterruptedException e){
            }
        }
        product_2d = queue_2d.poll();
        this.contents_2d -= product_2d.area;
        notifyAll();
        return product_2d;
    }
    public synchronized ThreeDProduct get_3d() {  //num为0:2d, 1:3d, tmp为面积/体积
        ThreeDProduct product_3d;
        while(this.contents_3d == 0){ //三维产品仓库为空
            try{
                throw new Exception("error: 三维产品仓库为空");
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            try {
                wait();
            } catch(InterruptedException e){
            }
        }
        product_3d = queue_3d.poll();
        this.contents_3d -= product_3d.volume;
        notifyAll();
        return product_3d;
    }
    public synchronized void put_2d(PlaneProduct product_2d) {
        while(contents_2d + product_2d.area > max_2d){
            try{
                throw new Exception("error: 二维产品仓库为空间不足");
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            try {
                wait();
            } catch(InterruptedException e){
            }
        }
        queue_2d.offer(product_2d);
        this.contents_2d += product_2d.area;
        notifyAll();
    }
    public synchronized void put_3d(ThreeDProduct product_3d) {
        while(contents_3d + product_3d.volume > max_3d){
            try{
                throw new Exception("error: 三维产品仓库为空间不足");
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
            try {
                wait();
            } catch(InterruptedException e){
            }
        }
        queue_3d.offer(product_3d);
        this.contents_3d += product_3d.volume;
        notifyAll();
    }
}

class Consumer extends Thread {
    private CubbyHole cubbyhole;
    private int D;   //维度
    private int choose;  // 类型(0, 1, 2)

    public Consumer(CubbyHole c, int D) {
        cubbyhole = c;
        this.D = D;
    }

    public void run() {
        Random random = new Random();
        while(true){
            if(D == 0){ //二维消费者
                PlaneProduct product_2d = cubbyhole.get_2d();
                product_2d.display(0);
            }else{ //D == 1, 三维消费者
                ThreeDProduct product_3d = cubbyhole.get_3d();
                product_3d.display(0);
            }
        }
    }
}

class Producer extends Thread {
    private CubbyHole cubbyhole;
    private int D;   //维度
    private int choose;  // 类型(0, 1, 2)

    public Producer(CubbyHole c, int D) {
        cubbyhole = c;
        this.D = D;
    }

    public void run() {
        Random random = new Random();
        while(true){
            if(D == 0){ //二维生产者
                PlaneProduct product_2d = new PlaneProduct();
                choose = random.nextInt(3);  //随机选择产品种类
                product_2d.planekind = choose;
                switch(choose){
                    case 0: //矩形
                        Rectangle rec = new Rectangle("rectangle", 10, 7);
                        rec.area_cal();
                        product_2d.name_producer = rec.name_producer;
                        product_2d.area = rec.area;
                        break;
                    case 1: //三角形
                        Triangle tri = new Triangle("triangle", 10, 10);
                        tri.area_cal();
                        product_2d.name_producer = tri.name_producer;
                        product_2d.area = tri.area;
                        break;
                    case 2: //梯形
                        Trapezoid tra = new Trapezoid("trapezoid", 10, 20, 4);
                        tra.area_cal();
                        product_2d.name_producer = tra.name_producer;
                        product_2d.area = tra.area;
                        break;
                }
                product_2d.display(1);
                cubbyhole.put_2d(product_2d);
                
                try {  //随机休息？
                    sleep((int)(Math.random() * 100));
                } catch (InterruptedException e) { }
            }
            else{  //D==1, 三维生产者
                ThreeDProduct product_3d = new ThreeDProduct();
                choose = random.nextInt(3);  //随机选择产品种类
                choose = 1;
                product_3d.planekind = choose;
                switch(choose){
                    case 0: //长方体
                        Cuboids cub = new Cuboids("cuboids", 5, 4, 4);
                        cub.volume_cal();
                        product_3d.name_producer = cub.name_producer;
                        product_3d.volume = cub.volume;
                        break;
                    case 1: //圆柱体
                        Cylinder cyl = new Cylinder("cylinder", 1, 20);
                        cyl.volume_cal();
                        product_3d.name_producer = cyl.name_producer;
                        product_3d.volume = cyl.volume;
                        break;
                    case 2: //球体
                        Sphere sph = new Sphere("sphere", 2);
                        sph.volume_cal();
                        product_3d.name_producer = sph.name_producer;
                        product_3d.volume = sph.volume;
                        break;
                }
                product_3d.display(1);
                cubbyhole.put_3d(product_3d);
                try {  //随机休息？
                    sleep((int)(Math.random() * 100));
                } catch (InterruptedException e) { }
            }
        }
    }
}
