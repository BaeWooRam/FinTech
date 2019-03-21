package com.example.fintech;

import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CheckMember {
    @Test
    /**
     * 이메일 포맷 체크
     * @param email
     * @return
     */
    public void test(){
//        System.out.println(checkEmail("betagogo@naver.com"));
//        System.out.println(checkEmail("betag@ogo"));
        System.out.println(checkPwd("beta@0000"));
        System.out.println(checkPwd("beta0000"));
        System.out.println(checkPwd("000000000"));
        System.out.println(checkPwd("betaggggg"));
        System.out.println(getSHA512("dnfka@8579"));
    }
    static boolean checkEmail(String email) {

        String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean isNormal = m.matches();
        return isNormal;

    }

    public static String getSHA512(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    //가장 많이 사용되는 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
    static boolean checkPwd(String pwd){
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
        Matcher m = p.matcher(pwd);

        if(m.matches()){
            return true;
        }
        return false;

    }
}