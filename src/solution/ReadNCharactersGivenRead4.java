package solution;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it 
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) 
 * that reads n characters from the file.
 * 
 * Note:
 * The read function will only be called once for each test case.
 * 
 * @author Dongliang Yu
 *
 */
public class ReadNCharactersGivenRead4 extends Reader4 {
    
    public ReadNCharactersGivenRead4(String s) {
        super(s);
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int i = 0;
        while (i < n) {
            int len = read4(tmp);
            if (len == 0) break; // n is too long
            if (i+len >= n) len = n-i;
            System.arraycopy(tmp, 0, buf, i, len);
            i += len;
        }
        return i;
    }
    
    public static void main(String[] args) {
        ReadNCharactersGivenRead4 reader = new ReadNCharactersGivenRead4("0123456789");
        char[] buf = new char[11];
        reader.read(buf, 9);
        reader.show(buf);
    }
}
