package java1;
//10-1000中素数的运算
public class one {
    public static void main(String[]args){
            int i,j,k=0;
            int sum=0;
            int max=1000;
            for(i=10;i<max;i++){
                boolean t=true;
               // 对此一步保留疑问，为啥j的初始值不能等于10；
                for(j=2;j<i;j++)
                {
                    if(i%j!=0)
                    {
                        continue;
                    }
                    else
                    {
                        t=false;
                        break;
                    }
                }
                if(t)
                {
                    k++;
                    System.out.println(i);
                    sum+=i;
                }
            }
            System.out.println("共有素数："+k);
            System.out.println("它们的和为："+sum);
        }
    }


