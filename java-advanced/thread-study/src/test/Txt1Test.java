package test;

public class Txt1Test {

    public static void main(String[] args) throws InterruptedException {

        String firstStr = "abcdefg12345";

        String secondStr = getEachCharInTheStr(firstStr);
        System.out.println(secondStr);
    }

    private static String getEachCharInTheStr(String str) throws InterruptedException {

        StringBuffer sb = new StringBuffer();

        for(int i = 0, len = str.length(); i < len; i++){
            Thread.sleep(500);
            System.out.print(str.charAt(i));
        }
        return sb.toString();
    }
}

