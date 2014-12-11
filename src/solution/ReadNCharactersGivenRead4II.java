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
 * The read function may be called multiple times.
 * 
 * @author Dongliang Yu
 *
 */
public class ReadNCharactersGivenRead4II extends Reader4 {
    
    private char[] saved;
    private int savedLen;
    
    public ReadNCharactersGivenRead4II(String s) {
        super(s);
        saved = new char[4];
        savedLen = 0;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        if (savedLen > 0) {
            System.arraycopy(saved, 0, buf, 0, savedLen);
            i += savedLen;
        }
        savedLen = 0;
        
        char[] tmp = new char[4];
        while (i < n) {
            int len = read4(tmp);
            if (len == 0) break; // n is too long
            if (i+len >= n) {
                savedLen = i+len-n;
                len = n-i;
                System.arraycopy(tmp, len, saved, 0, savedLen);
            }
            System.arraycopy(tmp, 0, buf, i, len);
            i += len;
        }
        return i;
    }
    
    public static void main(String[] args) {
        ReadNCharactersGivenRead4II reader = new ReadNCharactersGivenRead4II("ab");
        char[] buf = new char[11];
        reader.read(buf, 1);
        reader.show(buf, 1);
        
        reader.read(buf, 2);
        reader.show(buf, 2);
        
        /*
        ReadNCharactersGivenRead4II reader = new ReadNCharactersGivenRead4II("");
        char[] buf = new char[11];
        reader.read(buf, 1);
        reader.show(buf, 1);
        
        reader.read(buf, 2);
        reader.show(buf, 2);
        */
        
        /*
        ReadNCharactersGivenRead4II reader = new ReadNCharactersGivenRead4II("0123456789");
        char[] buf = new char[11];
        reader.read(buf, 1);
        reader.show(buf, 1);
        
        reader.read(buf, 3);
        reader.show(buf, 3);
        
        reader.read(buf, 2);
        reader.show(buf, 2);
        
        reader.read(buf, 1);
        reader.show(buf, 1);
        */
    }
}
