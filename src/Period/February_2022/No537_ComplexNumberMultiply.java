package Period.February_2022;

public class No537_ComplexNumberMultiply {
    public String complexNumberMultiply(String num1,String num2){
        int real1 = 0, real2 = 0;
        int img1 = 0, img2 = 0;
        boolean isReal = true, isPositive = true;
        for(int i=0;i<num1.length();i++){
            if(num1.charAt(i)=='-'){
                isPositive = false;
            }else if(num1.charAt(i)=='+'){
                real1 *= isPositive?1:-1;
                isReal = false;
                isPositive = true;
            }else if(num1.charAt(i)!='i'){
                if(isReal){
                    real1 *= 10;
                    real1 += (int)num1.charAt(i)-'0';
                }else{
                    img1 *= 10;
                    img1 += (int)num1.charAt(i)-'0';
                }
            }
        }
        img1 *= isPositive?1:-1;
        isReal = true;
        isPositive = true;
        for(int i=0;i<num2.length();i++){
            if(num2.charAt(i)=='-'){
                isPositive = false;
            }else if(num2.charAt(i)=='+'){
                real2 *= isPositive?1:-1;
                isReal = false;
                isPositive = true;
            }else if(num2.charAt(i)!='i'){
                if(isReal){
                    real2 *= 10;
                    real2 += (int)num2.charAt(i)-'0';
                }else{
                    img2 *= 10;
                    img2 += (int)num2.charAt(i)-'0';
                }
            }
        }
        img2 *= isPositive?1:-1;
        int real = real1*real2-img1*img2;
        int img = real1*img2+real2*img1;
        System.out.println(real1+" "+real2);
        System.out.println(img1+" "+img2);
        return String.valueOf(real)+"+"+String.valueOf(img)+"i";
    }

    public static void main(String[] args) {
        No537_ComplexNumberMultiply obj = new No537_ComplexNumberMultiply();
        System.out.println(obj.complexNumberMultiply("1+1i","1+1i"));
        System.out.println(obj.complexNumberMultiply("1+-1i","1+-1i"));
    }
}
