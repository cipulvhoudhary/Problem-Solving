
class Solution {
public int reverse(int x) {
int n=0,m,rev=0;
long re=0;
if(x>0){
while(x>0){
m=x%10;
rev=rev*10+m;
re=re*10+(long)m;
x=x/10;

    }
        if(re<=2147483647)return rev;
        else return 0;
    }
    else{
        x=x*-1;
        while(x>0){
        m=x%10;
        rev=rev*10+m;
            re=re*10+(long)m;
        x=x/10;
            
    }
        if(-re>=-2147483648)return -rev;
        else return 0;
    }

}
}