package com.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getUserInfo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList("姓名", "年龄"));
        System.out.println(getInfo("个人信息###北京通力互联技术服务有限公司###姓    名:冯磊###性    别:男###工作年限:4年###联系方式:17600212044###毕业学校: 2013—2017  西安科技大学高新学院 计算机与科学 | 本科###期望工作地区:北京###邮    箱:1666718960@qq.com###目前薪资:18k*12###期望薪资:22k*12###年     龄: 29###",hashSet));;
    }

    public static Map<String, String> getInfo(String infoStr, Set<String> keySet) {
        Map<String, String> result = new HashMap<String, String>();
        infoStr = infoStr.replace(" ", "");
        for (String key : keySet) {
            infoStr=infoStr.replaceAll(" ","");
            StringBuilder pattern = new StringBuilder();
            for (int i = 0; i < key.length(); i++) {
                pattern.append(key.substring(i, i + 1)).append("\\s*");
            }
            pattern.append(":(\\S*)###");

            // 创建 Pattern 对象
            Pattern r = Pattern.compile(pattern.toString());

            // 现在创建 matcher 对象
            Matcher m = r.matcher(infoStr);
            if (m.find()) {
                for (int i = 0; i < m.groupCount(); i++) {
                    System.out.println(m.group(i));
                }
                return null;
            }

        }
//        boolean isMatch = Pattern.matches(pattern, infoStr);
        return result;
    }
}
