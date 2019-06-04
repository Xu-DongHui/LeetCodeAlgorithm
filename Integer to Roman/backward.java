class Solution {
    public String intToRoman(int num) {
        String roman = "";
        int i = 0;
        int x = 0;
        // 将num从后往前逐位进行判断
        while(num > 0) {
            i++;
            // 第i位的值
            x = num % 10;
            // 高位的罗马数字拼接在前面
            roman = toSubRoman(i, x) + roman;
            num = num / 10;
        }
        return roman;
    }
    
    public String toSubRoman(int order, int num) {
        String big = "";
        String small = "";
        String next = "";
        String subRoman = "";
        // 每一位的单位不一样，先预先设定好
        switch(order) {
            case 1:
                big = "V";
                small = "I";
                next = "X";
                break;
            case 2:
                big = "L";
                small = "X";
                next = "C";
                break;
            case 3:
                big = "D";
                small = "C";
                next = "M";
                break;
            case 4:
                small = "M";
            default:
                break;
        }
        // 每一位的值都是1到9，拼接的思路是一样的，共分为四种情况
        if(num < 4) {
            for(int i = 0; i < num; i++) {
                subRoman = subRoman + small;
            }
        } else if(num == 4) {
            subRoman = small + big;
        } else if(num >= 5 && num < 9) {
            subRoman = big;
            for(int i = 5; i < num; i++) {
                subRoman = subRoman + small;
            }
        } else if(num == 9) {
            subRoman = small + next;
        }
        
        return subRoman;
    }
}