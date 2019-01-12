public static Integer romanInteger(String s) {
        HashMap<Character,Integer> ht = new HashMap<>();//感觉像作为数据库查询对应个分数
        ht.put('I',1);
        ht.put('V',5);
        ht.put('X',10);
        ht.put('L',50);
        ht.put('C',100);
        ht.put('D',500);
        ht.put('M',1000);
        int intNum = 0;
        int prev = 0;

        for (int i = s.length()-1; i >= 0; i--) {//从字符串的后面往前算
            int temp = ht.get(s.charAt(i));
            if (temp < prev){//当前面一个比后面一个小，就减去这个值
                intNum-= temp;
            }else {
                intNum+=temp;
            }
            prev = temp;
        }
        return intNum;
    }
