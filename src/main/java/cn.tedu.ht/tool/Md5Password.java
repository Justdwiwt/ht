package cn.tedu.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Password {

    /**
     * md5加密
     *
     * @param password pwd
     * @param username name
     * @return String
     */
    public static String getMd5HashPassword(String password, String username) {
        Md5Hash md5Hash = new Md5Hash(password, username, 3);
        return md5Hash.toString();
    }

//	public static void main(String[] args) {
//		String p = getMd5HashPassword("pppp", "admin");
//		System.out.println(p);
//	}

}
