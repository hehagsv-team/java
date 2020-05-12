import java.util.Arrays;
public class DeepCopy 
{ 
       private int[] data; 
    public DeepCopy(int[] values) { 
        data = new int[values.length]; 
        for (int i = 0; i < data.length; i++) { 
            data[i] = values[i]; 
        } 
    }   
    public void showData() { 
        System.out.println(Arrays.toString(data)); 
    }  
    public static void main(String[] args) { 
        int[] vals = {3, 7, 9}; 
        DeepCopy e = new DeepCopy(vals); 
        e.showData(); 
        vals[0] = 13; 
        e.showData(); 
    } 
} 