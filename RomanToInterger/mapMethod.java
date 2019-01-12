class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        for (int i = 0; i < s.length(); i += 1) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {//查询map的key， 查询并获得字符串的子符（2位字符）
                result += map.get(s.substring(i, i + 2));
                i += 1;
            } else result += map.get(s.substring(i, i + 1));//1位字符
        }
        return result;
    }
}
