package solution;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class Reader4 {
    private String file;
    private int offset;
    
    public Reader4(String s) {
        file = s;
        offset = 0;
    }
    
    public int read4(char[] buf) {
        int i = 0;
        while (i < 4 && offset+i < file.length()) {
            buf[i] = file.charAt(offset + i);
            i++;
        }
        offset += i;
        return i;
    }
    
    public void show(char[] buf) {
        for (char c : buf)
            System.out.print(c + ",");
        System.out.println();
    }
    
    public void show(char[] buf, int len) {
        for (int i = 0; i < Math.min(buf.length, len); i++)
            System.out.print(buf[i] + ",");
        System.out.println();
    }
    
    public static void main(String[] args) {
        char[] buf = new char[4];
        Reader4 reader = new Reader4("12345");
        int n = reader.read4(buf);
        System.out.println(n);
        reader.show(buf);
        
        buf = new char[4];
        n = reader.read4(buf);
        System.out.println(n);
        reader.show(buf);
    }
}
