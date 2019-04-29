package ut.math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BigIntegerTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test(expected = ArithmeticException.class)
    public void test_setBit() {
        byte[] b1 = new byte[]{(byte)0x5e,0x2d,(byte)0xca,0x18,(byte)0xa4,0x54,(byte)0xa3,0x12,(byte)0xb0,0x34,(byte)0xff,0x56};
        byte[] b2 = new byte[]{(byte)0x5e,0x2d,(byte)0xca,0x19,(byte)0xa4,0x54,(byte)0xa3,0x12,(byte)0xb0,0x34,(byte)0xff,0x56};
        BigInteger bigint1 = new BigInteger(b1);
        //测试用例1
        bigint1.setBit(-1);
        //测试用例2
        assertEquals(new BigInteger(b2),bigint1.setBit(64));

    }

    @Test(expected = ArithmeticException.class)
    public void test_clearBit() {
        byte[] b1 = new byte[]{(byte)0x5e,0x2d,(byte)0xca,0x18,(byte)0xa4,0x54,(byte)0xa3,0x12,(byte)0xb0,0x34,(byte)0xff,0x56};
        byte[] b2 = new byte[]{(byte)0x5e,0x2d,(byte)0xca,0x18,(byte)0xa4,0x54,(byte)0xa2,0x12,(byte)0xb0,0x34,(byte)0xff,0x56};
        BigInteger bigint1 = new BigInteger(b1);
        //测试用例1
        bigint1.setBit(-1);
        //测试用例2
        assertEquals(new BigInteger(b2),bigint1.clearBit(40));
    }

    @Test(expected = ArithmeticException.class)
    public void test_flipBit() {
        byte[] b1 = new byte[]{(byte)0x5e,0x2d,(byte)0xca,0x18,(byte)0xa4,0x54,(byte)0xa3,0x12,(byte)0xb0,0x34,(byte)0xff,0x56};
        byte[] b2 = new byte[]{(byte)0x5e,0x2d,(byte)0xca,0x18,(byte)0xa4,0x54,(byte)0xa2,0x12,(byte)0xb0,0x34,(byte)0xff,0x56};
        BigInteger bigint1 = new BigInteger(b1);
        //测试用例1
        bigint1.setBit(-1);
        //测试用例2
        assertEquals(new BigInteger(b2),bigint1.flipBit(40));
    }

    @Test
    public void test_toString_radix() {
        BigInteger bigint1 = new BigInteger("0");
        assertEquals("0",bigint1.toString(8));

        BigInteger bigint2 = new BigInteger("1024");
        assertEquals("1024",bigint2.toString(40));
        assertEquals("2000",bigint2.toString(8));   //10进制数1024 (10,000,000,000) = 8进制数2000

        BigInteger bigint3 = new BigInteger("3526908928771790520021682274278850163351843697869724515422870515203341601371741403415725842999527135490852889340814228922606856122768932773591727725745014187456168");
        String str = "fadceb52fda353fb87928938870d575a08748f27ad513043282160aebea23d4a05b857c648a6a5bb7cd1b72cefc220b48f3ce996f652d69f973e58c36a67283dd8376a8";
        assertEquals(str,bigint3.toString(16));
        BigInteger bigint4 = new BigInteger("-3526908928771790520021682274278850163351843697869724515422870515203341601371741403415725842999527135490852889340814228922606856122768932773591727725745014187456168");
        assertEquals("-"+str,bigint4.toString(16));

//        BigInteger bigint5 = new BigInteger(540,new Random(1000));
//        System.out.println(bigint5);
//        assertEquals("2000",bigint5.toString(16));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}