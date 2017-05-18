/*
请编写一个方法，将字符串中的空格全部替换为“%20”。
假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
*/

// 正则
public String replaceSpace(String iniString, int length) {
   return iniString.replaceAll(" ", "%20");
}
// 或者
public String replaceSpace(String iniString, int length) {
    StringBuilder sb = new StringBuilder();                       
    for (int i = 0; i < length; i++) {                            
        char c = iniString.charAt(i);   
        if(c == ' '){          
            sb.append("%20");    
        }else{  
            sb.append(c);
        }                                                      
    }                                                             
    return sb.toString();                                         
}        